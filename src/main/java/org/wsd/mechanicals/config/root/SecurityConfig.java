package org.wsd.mechanicals.config.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:META-INF/spring/applicationContext-security.xml")
public class SecurityConfig {

}
