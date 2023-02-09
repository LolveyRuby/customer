package com.thread.xb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan(basePackages = {"com.thread.xb.mapper"})
public class SplitexportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitexportApplication.class, args);
	}

}
