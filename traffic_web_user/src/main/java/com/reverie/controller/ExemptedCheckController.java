package com.reverie.controller;


import com.reverie.domain.Applyexemptedcheck;
import com.reverie.service.ApplyExemptedCheckService;
import com.reverie.utils.DateUtil;
import com.reverie.utils.Rename_String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exemptedCheck")
@CrossOrigin
public class ExemptedCheckController {
    @Autowired
    private ApplyExemptedCheckService applyExemptedCheckService;

    @RequestMapping("/uploadInsurance")
    @ResponseBody
    public String uploadInsurance(@RequestParam("file") MultipartFile mfile, @RequestParam("username")String username,HttpServletRequest request) throws IOException {
        System.out.println("/uploadInsurance------------------------------");
        String originalFilename = mfile.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/images");
        String rename = Rename_String.rename(originalFilename);
        System.out.println(rename + "  -------------");
        String userDir= realPath + "/" + username;
        File userfile=new File(userDir);
        if(!userfile.exists()){
            userfile.mkdirs();
        }
        String exemptedDir=userDir+"/exemptedCheck";
        File exemptedCheckFile=new File(exemptedDir);
        if(!exemptedCheckFile.exists()){
            exemptedCheckFile.mkdirs();
        }
        String target = exemptedDir + "/" + username+ "_insurance"+ DateUtil.getCurrentDateStr()+".jpg";
        // String target = realPath + "/" + rename;
        System.out.println(target);
        mfile.transferTo(new File(target));
        String url="http://localhost:8081/images/"+username+"/exemptedCheck/"+username+"_insurance"+DateUtil.getCurrentDateStr()+".jpg";
        return url;
    }

    @RequestMapping("/uploadTax")
    @ResponseBody
    public String uploadTax(@RequestParam("file") MultipartFile mfile, @RequestParam("username")String username,HttpServletRequest request) throws IOException {
        System.out.println("/uploadTax------------------------------");
        String originalFilename = mfile.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/images");
        String rename = Rename_String.rename(originalFilename);
        System.out.println(rename + "  -------------");
        String userDir= realPath + "/" + username;
        File userfile=new File(userDir);
        if(!userfile.exists()){
            userfile.mkdirs();
        }
        String exemptedDir=userDir+"/exemptedCheck";
        File exemptedCheckFile=new File(exemptedDir);
        if(!exemptedCheckFile.exists()){
            exemptedCheckFile.mkdirs();
        }
        String target = exemptedDir + "/" + username+ "_tax"+DateUtil.getCurrentDateStr()+".jpg";
        // String target = realPath + "/" + rename;
        System.out.println(target);
        mfile.transferTo(new File(target));
        String url="http://localhost:8081/images/"+username+"/exemptedCheck/"+username+"_tax"+DateUtil.getCurrentDateStr()+".jpg";
        return url;
    }

    @RequestMapping("/exemptCheckApply")
    @ResponseBody
    public Map<String,Object>  exemptCheckApply(Applyexemptedcheck applyexemptedcheck, @RequestParam("endTime")String endTime, HttpServletRequest request) throws IOException, ParseException {
        Map<String,Object> map=new HashMap<>();
        applyexemptedcheck.setStatus("2");
        applyexemptedcheck.setEndDate(DateUtil.getDateByFormatString("yyyy-MM-dd",endTime));
        applyexemptedcheck.setApplyDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss",DateUtil.getCurrentTimeStr()));
        System.out.println(applyexemptedcheck);
        String acNumber = applyExemptedCheckService.save(applyexemptedcheck);
        if(acNumber!=null){
            map.put("issuccess",true);
            map.put("acNumber",acNumber);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    @RequestMapping("/userapply")
    @ResponseBody
    public Map<String,Object>  userapply(String username){
        Map<String,Object> map=new HashMap<>();
        List<Applyexemptedcheck> applyexemptedchecks = applyExemptedCheckService.selectByUser(username);
        if(applyexemptedchecks!=null){
            map.put("issuccess",true);
            map.put("applyexemptedchecks",applyexemptedchecks);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    @RequestMapping("/info")
    @ResponseBody
    public Map<String,Object>  viewInfo(String acNumber){
        Map<String,Object> map=new HashMap<>();
        Applyexemptedcheck applyexemptedcheck = applyExemptedCheckService.selectoneById(acNumber);
        if(applyexemptedcheck!=null){
            map.put("issuccess",true);
            map.put("applyExemptedCheck",applyexemptedcheck);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

}
