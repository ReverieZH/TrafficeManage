package com.reverie.service;

import com.reverie.domain.Applyexemptedcheck;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ApplyExemptedCheckService {
    public Applyexemptedcheck selectoneById(String acNumber);

    List<Applyexemptedcheck> selctAll();

    public List<Applyexemptedcheck> selectByUser(String username);

    public String save(Applyexemptedcheck applyexemptedcheck);

    public int accpet(String acNumber,String status);
}
