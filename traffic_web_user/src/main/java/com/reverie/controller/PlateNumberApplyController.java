package com.reverie.controller;


import com.reverie.domain.Applyednumber;
import com.reverie.domain.Platenumber;
import com.reverie.domain.Platenumberapply;
import com.reverie.domain.Userplateapply;
import com.reverie.service.ApplyedNumberService;
import com.reverie.service.PlateNumberApplyService;
import com.reverie.service.PlateNumberService;
import com.reverie.service.UserPlateApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plateApply")
@CrossOrigin
public class PlateNumberApplyController {

    @Autowired
    private PlateNumberService plateNumberService;

    @Autowired
    private PlateNumberApplyService plateNumberApplyService;
    @Autowired
    private UserPlateApplyService userPlateApplyService;

    @Autowired
    private ApplyedNumberService applyedNumberService;

    /**
    * @Description: 页面调度
    * @Date:
    * @Author:
    */

    @RequestMapping("/dispatch")
    @ResponseBody
    public Map<String,Object>  dispatch(String username){
        Map<String,Object> map=new HashMap<>();
        Userplateapply userPlateApply = userPlateApplyService.selectPlateApplyedByUser(username);
        if(userPlateApply!=null){
            map.put("isApplyed",true);
            map.put("plateNumberApply",userPlateApply.getPlatenumberapply());
        }else{
            map.put("isApplyed",false);
        }

        return map;
    }

    /**
    * @Description: 提交申请
    * @Date:
    * @Author:
    */
    @RequestMapping("/plateApply")
    @ResponseBody
    public Map<String,Object> apply(Platenumberapply platenumberapply){
        Map<String,Object> map=new HashMap<>();
        boolean issuccess=false;
        platenumberapply.setStatus("2");
        String applyNumber;
        applyNumber=plateNumberApplyService.save(platenumberapply);
        if(applyNumber!=null){
            Userplateapply userPlateApply=new Userplateapply();
            userPlateApply.setApplyNumber(applyNumber);
            userPlateApply.setUsername(platenumberapply.getUsername());
            int save = userPlateApplyService.save(userPlateApply);
            if(save>0){
                map.put("applyNumber",applyNumber);
                map.put("issuccess",true);
            }else {
                map.put("issuccess",false);
            }
        }else{
            map.put("issuccess",false);
        }
        return map;
    }


    /**
    * @Description: 获取申请车牌的详细信息
    * @Date:
    * @Author:
    */
    @RequestMapping("/applyInfo")
    @ResponseBody
    public Map<String,Object> applyInfo(String applyNumber){
        Map<String,Object> map=new HashMap<>();
        boolean issuccess=false;
        Platenumberapply platenumberapply = plateNumberApplyService.selectByKey(applyNumber);
        if(applyNumber!=null){
            map.put("platenumberapply",platenumberapply);
            map.put("issuccess",true);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    /**
    * @Description: 获取可用车牌号
    * @Date:
    * @Author:
    */
    @RequestMapping("/getNumbers")
    @ResponseBody
    public Map<String,Object> getUseableNumbers(String province,String city){
        boolean issuccess=false;
        Map<String,Object> map=new HashMap<>();
        List<Platenumber> platenumbers = plateNumberService.selectUsableNumber(province,city);
        if(platenumbers!=null){
            map.put("issuccess",true);
            map.put("platenumbers",platenumbers);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }


    /**
    * @Description: 获取用户已有车牌
    * @Date:
    * @Author:
    */
    @RequestMapping("/applyed")
    @ResponseBody
    public Map<String,Object> getUseApplyedNumbers(String username){
        Map<String,Object> map=new HashMap<>();
        List<Applyednumber> applyednumbers = applyedNumberService.selectPlateNumber(username);
        if(applyednumbers!=null){
            map.put("issuccess",true);
            map.put("applyednumbers",applyednumbers);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    /**
    * @Description: 选择车牌
    * @Date:
    * @Author:
    */
    @RequestMapping("/choose")
    @ResponseBody
    public String choosePlateNumber(Applyednumber applyednumber){
        boolean issuccess=false;
        Map<String,Object> map=new HashMap<>();
        int total=applyedNumberService.save(applyednumber);
        if(total>0){
            String plateNumber=applyednumber.getPlatenumber();
            plateNumberService.changeStatus(plateNumber,"2");
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    /**
    * @Description: 获取申请车牌的详细信息
    * @Date:
    * @Author:
    */
    @RequestMapping("/getInfo")
    @ResponseBody
    public Map<String,Object> getApplyInfo(String applyNumber){
        Map<String,Object> map=new HashMap<>();
        Platenumberapply platenumberapply = plateNumberApplyService.selectByKey(applyNumber);
        if(platenumberapply!=null){
            map.put("issuccess",true);
            map.put("plateNumberApply",platenumberapply);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

    @RequestMapping("/getUserApply")
    @ResponseBody
    public Map<String,Object> getUserApply(String username){
        Map<String,Object> map=new HashMap<>();
        List<Platenumberapply> platenumberapplys=plateNumberApplyService.selectByUsername(username);
        if(platenumberapplys!=null){
            map.put("issuccess",true);
            map.put("platenumberapplys",platenumberapplys);
        }else {
            map.put("issuccess",false);
        }
        return map;
    }
}
