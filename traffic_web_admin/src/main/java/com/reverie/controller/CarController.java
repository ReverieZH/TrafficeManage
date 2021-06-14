package com.reverie.controller;

import com.reverie.domain.Car;
import com.reverie.domain.LayUI;
import com.reverie.domain.Platenumber;
import com.reverie.domain.Vehiclelicense;
import com.reverie.service.CarService;
import com.reverie.service.PlateNumberService;
import com.reverie.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/main.do")
    public String getMainPage(HttpServletRequest request){
        return "carList";
    }

    @RequestMapping("/datamain.do")
    @ResponseBody
    public LayUI getPlateNumberList(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30")Integer limit){

        System.out.println("-----------------------------");
        LayUI<Car> layUI=new LayUI();
        List<Car> cars = carService.selectAll();
        if(cars!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(cars.size());
            layUI.setData(cars);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/search.do")
    @ResponseBody
    public LayUI search(HttpServletRequest request,  @RequestParam String plateNumber){
        LayUI<Car> layUI=new LayUI();
        List<Car> cars = carService.searchByPlateNumber(plateNumber);
        if(cars!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(cars.size());
            layUI.setData(cars);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/searchByName.do")
    @ResponseBody
    public LayUI searchByName(HttpServletRequest request,  @RequestParam String name){
        LayUI<Car> layUI=new LayUI();
        List<Car> cars = carService.searchByName(name);
        if(cars!=null){
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(cars.size());
            layUI.setData(cars);
        }else{
            layUI.setCode("0");
            layUI.setMsg("成功");
            layUI.setCount(0);
            layUI.setData(null);
        }
        return layUI;
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public String add(){
        return "xixi";
    }

    @RequestMapping("/getaddCar.do")
    public String getaddPlateNumber(HttpServletRequest request){
        return "addCar";
    }


    @RequestMapping("/addCar.do")
    @ResponseBody
    public String addCar(HttpServletRequest request,Car car,@RequestParam String date) throws ParseException {
        boolean issuccess =false;
        System.out.println("=============="+car);
        car.setProduceDate(DateUtil.getDateByFormatString("yyyy-MM-dd",date));
        car.setRegistationDate(DateUtil.getSqlDateByFormatString("yyyy-MM-dd", DateUtil.getCurrentTime()));
        issuccess=carService.save(car)>0?true:false;
        return String.valueOf(issuccess);
    }

  /*  @RequestMapping("/deleteList.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("plateNumber")List<String> palteNumberList){
        boolean issuccess=false;
        int total=plateNumberService.deleteList(palteNumberList);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }
*/
    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response, @RequestParam("plateNumber")String palteNumber){
        boolean issuccess=false;
        int total=carService.delete(palteNumber);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }



    @RequestMapping("changeStatus.do")
    @ResponseBody
    public String changeStatus(@RequestParam("plateNumber")String plateNumber,@RequestParam("status")String status){
        boolean issuccess=false;
        int total=carService.changeStatus(plateNumber,status);
        if(total>0){
            issuccess=true;
        }
        return String.valueOf(issuccess);
    }

    @RequestMapping("geteditCar.do")
    public String geteditCar(HttpServletRequest request,@RequestParam("plateNumber")String plateNumber){
        Car car = carService.selectByKey(plateNumber);
        request.setAttribute("car",car);
        return "editCar";
    }
    @RequestMapping("/editCar.do")
    @ResponseBody
    public String editCar(HttpServletRequest request,Car car) throws ParseException {
        boolean issuccess =false;
        issuccess=carService.update(car)>0?true:false;
        return String.valueOf(issuccess);
    }
}
