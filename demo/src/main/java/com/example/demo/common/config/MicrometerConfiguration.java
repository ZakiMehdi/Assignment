package com.example.demo.common.config;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MicrometerConfiguration {

	@Bean
	MeterRegistryCustomizer<?> meterCustomizer(MeterRegistry meterRegistry) {
		
		return meterRegistry1->{
			meterRegistry.config()
			.commonTags("application","micrometer-api-application");
		};
	}
}
