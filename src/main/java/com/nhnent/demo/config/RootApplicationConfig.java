package com.nhnent.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.nhnent.demo.service.*"})
public class RootApplicationConfig {
}
