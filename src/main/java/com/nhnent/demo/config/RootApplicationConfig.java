package com.nhnent.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//TODO 1. ComponentScan의 basePackage 속성에 Bean생성 대상 클래스가 있는 classpath 이름을 넣어주세요.
//TODO 1. ComponentScanのbasePackage属性にBean生成対象クラスがあるclasspathの名前を入れてください。
@ComponentScan(basePackages = {"com.nhnent........."})
public class RootApplicationConfig {
}
