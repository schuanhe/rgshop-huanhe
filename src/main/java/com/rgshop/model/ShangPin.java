package com.rgshop.model;

public class ShangPin {
    private Integer spid;
    private String spbh;
    private String spmc;
    private Float spdj;
    private Integer spsl;
    private String spbz;

    // <Alt> + <Insert>
    // 必须包含空（无参）的构造方法
    public ShangPin() {
    }

    // 推荐包含全参数构造方法

    public ShangPin(Integer spid, String spbh, String spmc, Float spdj, Integer spsl, String spbz) {
        this.spid = spid;
        this.spbh = spbh;
        this.spmc = spmc;
        this.spdj = spdj;
        this.spsl = spsl;
        this.spbz = spbz;
    }


    // 每个参数的访问器与设置器
    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSpbh() {
        return spbh;
    }

    public void setSpbh(String spbh) {
        this.spbh = spbh;
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    public Float getSpdj() {
        return spdj;
    }

    public void setSpdj(Float spdj) {
        this.spdj = spdj;
    }

    public Integer getSpsl() {
        return spsl;
    }

    public void setSpsl(Integer spsl) {
        this.spsl = spsl;
    }

    public String getSpbz() {
        return spbz;
    }

    public void setSpbz(String spbz) {
        this.spbz = spbz;
    }

    @Override
    public String toString() {
        return "ShangPin{" +
                "spid=" + spid +
                ", spbh='" + spbh + '\'' +
                ", spmc='" + spmc + '\'' +
                ", spdj=" + spdj +
                ", spsl=" + spsl +
                ", spbz='" + spbz + '\'' +
                '}';
    }
}
