package com.informatorio.blog_info.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}


/*
	PROPIEDADES BASE DE DATOS APPLICATION.PROPERTIES

spring.jpa.database= MYSQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.datasoruce.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/database_info?useSSL=false&serverTimezone=UTC&useUnicode=true
spring.datasource.username=root
spring.datasource.password=rodrigoz09


POSIBLES DEPENDENCIAS UTILES
<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
*/