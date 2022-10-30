package com.rgshop.model;

public class ShangPinQuery {
    private String spbh;
    private String spmc;
    private Float spdj_from;
    private Float spdj_to;
    private Integer spsl_from;
    private Integer spsl_to;
    private String spbz;

    public ShangPinQuery() {
    }

    public ShangPinQuery(String spbh, String spmc, Float spdj_from, Float spdj_to, Integer spsl_from, Integer spsl_to, String spbz) {
        this.spbh = spbh;
        this.spmc = spmc;
        this.spdj_from = spdj_from;
        this.spdj_to = spdj_to;
        this.spsl_from = spsl_from;
        this.spsl_to = spsl_to;
        this.spbz = spbz;
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

    public Float getSpdj_from() {
        return spdj_from;
    }

    public void setSpdj_from(Float spdj_from) {
        this.spdj_from = spdj_from;
    }

    public Float getSpdj_to() {
        return spdj_to;
    }

    public void setSpdj_to(Float spdj_to) {
        this.spdj_to = spdj_to;
    }

    public Integer getSpsl_from() {
        return spsl_from;
    }

    public void setSpsl_from(Integer spsl_from) {
        this.spsl_from = spsl_from;
    }

    public Integer getSpsl_to() {
        return spsl_to;
    }

    public void setSpsl_to(Integer spsl_to) {
        this.spsl_to = spsl_to;
    }

    public String getSpbz() {
        return spbz;
    }

    public void setSpbz(String spbz) {
        this.spbz = spbz;
    }

    @Override
    public String toString() {
        return "ShangPinQuery{" +
                "spbh='" + spbh + '\'' +
                ", spmc='" + spmc + '\'' +
                ", spdj_from=" + spdj_from +
                ", spdj_to=" + spdj_to +
                ", spsl_from=" + spsl_from +
                ", spsl_to=" + spsl_to +
                ", spbz='" + spbz + '\'' +
                '}';
    }
}
