package com.reverie.aop;

import com.reverie.domain.Syslog;
import com.reverie.service.SyslogService;
import com.reverie.utils.LogUtils;
import com.reverie.utils.RequestHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
@Order(2)
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SyslogService syslogService;

    private Date visitTime;//开始时间
    private Class clazz;    //访问的类
    private String className;    //访问的类名
    private String methodName;  //访问的方法
    private Method method;

    //前置通知   主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* com.reverie.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = jp.getTarget().getClass();//具体要访问的类
        className=clazz.getSimpleName();
        methodName = jp.getSignature().getName();//获取访问的方法的名称

        MethodSignature signature = (MethodSignature) jp.getSignature();
        method = signature.getMethod();
//        com.codermy.myspringsecurityplus.log.aop.MyLog myLog = method.getAnnotation(com.codermy.myspringsecurityplus.log.aop.MyLog.class);
        // 方法路径
       /* String methodName = jp.getTarget().getClass().getName()+"."+signature.getName()+"()";
        StringBuilder params = new StringBuilder("{");
        //参数值
        Object[] argValues = jp.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)jp.getSignature()).getParameterNames();

        if(argNames == null || argNames.length == 0){
            method = clazz.getMethod(methodName);//只能获取无参数的方法
        }else {
            Class[] classArgs = new Class[argNames.length];
            for (int i = 0; i < argNames.length; i++) {
                classArgs[i] = argNames[i].getClass();
            }
            method = clazz.getMethod(methodName,classArgs);
        }*/
    }

    //后置通知
    @After("execution(* com.reverie.controller.*.*(..))")
    public void doAfter(){
        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长

        String url = "";
        //获取url
        if(clazz != null && methodName != null && clazz != LogAop.class){
            //1、获取类上的RequestMapping
            RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation != null){
                String[] classValue = classAnnotation.value();
                //2、获取方法上的RequestMapping（xxx）
                RequestMapping methodAnnotation= method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                   /* if (url.equals("/users/importDept.do")){
                        return;
                    }*/
                    //获取访问的ip地址
                    HttpServletRequest request = RequestHolder.getHttpServletRequest();
//                    String ip = request.getRemoteAddr();
                    String ip= LogUtils.getIp(request);
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到Syslog对象
                    Syslog syslog = new Syslog();
                    syslog.setJobnumber(username);
                    syslog.setExecutionTime(time);//执行时长
                    syslog.setIp(ip);
                    syslog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                    syslog.setUrl(url);
                    //syslog.setUid(1);
                    syslog.setVisitTime(visitTime);
                    if(clazz.getName().equals("com.reverie.controller.SyslogController")){
                        return;
                    }else {
                        //调用Service完成操作
                        syslogService.save(syslog);
                    }
                }
            }
        }

    }
}
