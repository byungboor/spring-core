package com.nhndooray.edu.spring_core.config;

import com.nhndooray.edu.spring_core.service.ServiceMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ServiceMarker.class)
public class Config {

}