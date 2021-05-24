package com.reverie.domain;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Userplateapply {
    @Id
    private Integer id;
    private String username;
    private String applyNumber;
    @Transient
    private Platenumberapply platenumberapply;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber;
    }

    public Platenumberapply getPlatenumberapply() {
        return platenumberapply;
    }

    public void setPlatenumberapply(Platenumberapply platenumberapply) {
        this.platenumberapply = platenumberapply;
    }

    @Override
    public String toString() {
        return "UserPlateApply{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", applyNumber='" + applyNumber + '\'' +
                ", platenumberapply=" + platenumberapply +
                '}';
    }
}
