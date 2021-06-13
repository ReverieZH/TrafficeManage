package com.reverie.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
public class SecurityConfigUser extends WebSecurityConfigurerAdapter {
    //配置类方式
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1.创建配置类，说明使用哪个配置类
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    //加密时要用到这个对象
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();

        http.formLogin()
                .loginPage("/Login.jsp")
                .loginProcessingUrl("/login")    //登录访问路径
                .failureUrl("/Login.jsp?error=true")
                .defaultSuccessUrl("/manage/main.do",true).permitAll()              //登录成功之后，跳转路径
                .and().authorizeRequests()
                  .antMatchers("/","/manage/login.do").permitAll()   //设置哪些路径可以直接访问，不需要认证
                  //当前登录用户，只有具有admins权限才可以访问这个路径
                    //1 hasAuthority
                    .antMatchers("/manage/main.do").hasAnyAuthority("admins")   //设置哪些路径可以直接访问，不需要认证
                    //2 hasAnyAuthority
                     //.antMatchers("/test/index").hasAnyAuthority("admins,manager")   //设置哪些路径可以直接访问，不需要认证
                    //3.hasRole("role")
                     //.antMatchers("/test/index").hasRole("sale")
                //4.hasAnyRole
                     .antMatchers("/man/index").hasAnyRole("sale")
                .anyRequest().authenticated()   //所有请求都可以访问
                 .and().csrf().disable();   //关闭csrf防护
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello");

    }
}
