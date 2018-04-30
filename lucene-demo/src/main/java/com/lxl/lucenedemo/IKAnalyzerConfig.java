package com.lxl.lucenedemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/28
 */
@Configuration
@ImportResource(locations = {"classpath:IKAnalyzer.cfg.xml"})
public class IKAnalyzerConfig {
}
