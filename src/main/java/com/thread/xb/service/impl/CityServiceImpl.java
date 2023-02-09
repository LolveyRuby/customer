package com.thread.xb.service.impl;

import com.thread.xb.mapper.CityMapper;
import com.thread.xb.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;


    @Override
    public List<Map> cityQuery() {
        return cityMapper.cityQuery();
    }
}
