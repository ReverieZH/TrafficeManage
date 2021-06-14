package com.reverie.service.impl;

import com.reverie.domain.Drivinglicence;
import com.reverie.domain.Trafficoffence;
import com.reverie.mapper.DrivingLicenceBindingMapper;
import com.reverie.mapper.DrivinglicenceMapper;
import com.reverie.mapper.TrafficOffenceMapper;
import com.reverie.service.TrafficOffenceService;
import com.reverie.utils.Common;
import com.reverie.utils.DateUtil;
import com.reverie.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrafficOffenceServiceImpl implements TrafficOffenceService {
    @Autowired
    private TrafficOffenceMapper trafficOffenceMapper;

    @Autowired
    private DrivinglicenceMapper drivinglicenceMapper;

    @Autowired
    private DrivingLicenceBindingMapper drivingLicenceBindingMapper;


    @Override
    public List<Trafficoffence> selectByCar(String plateNumber) {
        Trafficoffence trafficoffence=new Trafficoffence();
        trafficoffence.setPlateNumber(plateNumber);
        trafficoffence.setStatus("2");
        return trafficOffenceMapper.select(trafficoffence);
    }

    @Override
    public List<Trafficoffence> selectAll() {
        return trafficOffenceMapper.selectAll();
    }

    @Override
    public Trafficoffence selectById(String trafficOffenceNumber) {
        Trafficoffence trafficoffence=new Trafficoffence();
        trafficoffence.setTrafficOffenceNumber(trafficOffenceNumber);
        return trafficOffenceMapper.selectByPrimaryKey(trafficoffence);
    }

    @Override
    @Transactional
    public boolean handleIllegal(String username, int score, String trafficOffenceNumber,String status) {
        try {
            if (status.equals("1")) {    //接受处罚
                System.out.println("接受处罚");
                Drivinglicence drivinglicence = drivingLicenceBindingMapper.selectByUser(username);
                Integer oldScore = drivinglicence.getScore();
                drivinglicence.setScore(oldScore + score);
                int dlUpdate = drivinglicenceMapper.updateByPrimaryKeySelective(drivinglicence);

                Trafficoffence trafficoffence = new Trafficoffence();
                trafficoffence.setTrafficOffenceNumber(trafficOffenceNumber);
                trafficoffence.setStatus(status);
                int toUpdate = trafficOffenceMapper.updateByPrimaryKeySelective(trafficoffence);
                if (dlUpdate > 0 && toUpdate > 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (status.equals("0")) {   //不接受处罚
                System.out.println("不接受处罚");
                Trafficoffence trafficoffence = new Trafficoffence();
                trafficoffence.setTrafficOffenceNumber(trafficOffenceNumber);
                trafficoffence.setStatus(status);
                int toUpdate = trafficOffenceMapper.updateByPrimaryKeySelective(trafficoffence);
                if (toUpdate > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int save(Trafficoffence trafficoffence) {
        String maxNumber = trafficOffenceMapper.getMaxNumber(DateUtil.getCurrentDateStr()+"%");
        String trafficOffenceNumber="";
        int total=0;
        if(maxNumber!=null){
            String maxNumStr = StringUtil.getMaxNum(maxNumber);
            Integer maxNum= Integer.valueOf(maxNumStr)+1;
            trafficOffenceNumber=DateUtil.getCurrentDateStr()+ Common.addZeroToString(String.valueOf(maxNum),3);
        }else{
            trafficOffenceNumber=DateUtil.getCurrentDateStr()+"001";
        }
        trafficoffence.setTrafficOffenceNumber(trafficOffenceNumber);
        return trafficOffenceMapper.insert(trafficoffence);
    }

    @Override
    public int update(Trafficoffence trafficoffence) {
        return trafficOffenceMapper.updateByPrimaryKeySelective(trafficoffence);
    }

    @Override
    public List<Trafficoffence> searchByPlate(String plateNumberStr) {
        String plateNumber="%"+plateNumberStr+"%";
        return trafficOffenceMapper.searchByPlate(plateNumber);
    }

    @Override
    public List<Trafficoffence> searchById(String trafficOffenceNumberStr) {
        String trafficOffenceNumber="%"+trafficOffenceNumberStr+"%";
        return trafficOffenceMapper.searchById(trafficOffenceNumber);
    }
}
