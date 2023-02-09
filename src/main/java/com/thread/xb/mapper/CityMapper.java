package com.thread.xb.mapper;

import com.thread.xb.entity.City;

import java.util.List;
import java.util.Map;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City row);

    int insertSelective(City row);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City row);

    int updateByPrimaryKey(City row);

    List<Map> cityQuery();
}
