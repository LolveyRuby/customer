package com.thread.xb.controller;

import com.thread.xb.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/city")
@Api(value = "城市接口", tags = {"城市接口"})
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @ApiOperation("根据条件查询用户")
    @GetMapping(value = "/test")
    public Object cityService() {
        return cityService.cityQuery();
    }


    @ApiOperation("制造死锁")
    @GetMapping("/create")
    public int test() {
//        stringRedisTemplate.delete("lock");
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent("lock", "lock");
        stringRedisTemplate.expire("lock",30, TimeUnit.SECONDS);
        return 1;
    }
}
