package com.willshuhua.adibioadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.willshuhua.adibioadmin.dao"})
@EnableTransactionManagement
@SpringBootApplication
public class AdibioadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdibioadminApplication.class, args);
	}
}
