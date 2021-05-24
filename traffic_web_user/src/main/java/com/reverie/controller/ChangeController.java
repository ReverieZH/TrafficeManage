package com.reverie.controller;


import com.reverie.domain.Losereplace;
import com.reverie.domain.Trafficoffence;
import com.reverie.service.LoseReplaceService;
import com.reverie.service.TrafficOffenceService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/change")
@CrossOrigin
public class ChangeController {

    @Autowired
    private LoseReplaceService loseReplaceService;


    @RequestMapping("/lose")
    @ResponseBody
    public Map<String,Object> loseReplace(Losereplace losereplace) throws ParseException {
        Map<String,Object> map=new HashMap<>();
        losereplace.setApplyDate(DateUtil.getDateByFormatString("yyyy-MM-dd HH:mm:ss", DateUtil.getCurrentTime()));
        losereplace.setStatus("2");
        String loseReplaceNumber = loseReplaceService.save(losereplace);
        if(loseReplaceNumber!=null){
            map.put("issuccess",true);
            map.put("loseReplaceNumber",loseReplaceNumber);
        }else{
            map.put("issuccess",false);
        }
        return map;
    }

}
