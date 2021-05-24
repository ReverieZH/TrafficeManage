package com.reverie.service;

import com.reverie.domain.Userplateapply;

public interface UserPlateApplyService {

    public Userplateapply selectPlateApplyedByUser(String username);

    public int save(Userplateapply userPlateApply);
}
