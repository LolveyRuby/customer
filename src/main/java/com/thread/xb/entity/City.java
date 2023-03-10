package com.thread.xb.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("城市对象")
public class City {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("地区")
    private String state;

    @ApiModelProperty("国家")
    private String country;

    public City(Integer id, String name, String state, String country) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
    }

    public City() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
}
