package com.beini.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
//@ConfigurationProperties(prefix="beini.properties")
//@PropertySource(encoding="UTF-8", value = { "classpath:application.properties" })
public class BeiniPropertiesConfig {
	@Value("${beini.properties.name}")
	private String name;
}
