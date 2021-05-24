package com.reverie.service.impl;

import com.reverie.domain.Userplateapply;
import com.reverie.mapper.UserPlateApplyMapper;
import com.reverie.service.UserPlateApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userPlateApplyService")
@Transactional
public class UserPlateApplyServiceImpl  implements UserPlateApplyService {
   @Autowired
   private UserPlateApplyMapper userPlateApplyMapper;

    @Override
    public Userplateapply selectPlateApplyedByUser(String username) {
        return userPlateApplyMapper.selectPalteApply(username);
    }

    @Override
    public int save(Userplateapply userPlateApply) {
        return userPlateApplyMapper.insert(userPlateApply);
    }
}
