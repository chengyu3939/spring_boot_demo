package com.mark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@MapperScan(basePackages = "com.mark.data")
//@ConditionalOnMissingClass
public class SpringBootDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
