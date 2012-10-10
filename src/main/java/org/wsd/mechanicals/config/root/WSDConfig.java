package org.wsd.mechanicals.config.root;

import org.springframework.beans.factory.aspectj.EnableSpringConfigured;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

@EnableSpringConfigured
@Configuration
@ComponentScan(basePackages = {"org.wsd.mechanicals.app", "org.wsd.mechanicals.config.root"}, scopedProxy = ScopedProxyMode.TARGET_CLASS, excludeFilters = @Filter(Controller.class))
public class WSDConfig {

}