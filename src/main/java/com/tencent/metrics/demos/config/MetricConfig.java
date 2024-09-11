package com.tencent.metrics.demos.config;


import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.MeterRegistry.Config;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Value("${spring.application.name:}")
    private String name;

    @Value("${code.code_builder:}")
    private String builder;

    @Value("${code.git_release:}")
    private String release;

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry ->  {
            Config config = registry.config().commonTags("application", name).commonTags("module_type", "pro-group");
            if (StringUtils.isNotBlank(builder)) {
                config.commonTags("code_builder", builder);
            }
            if (StringUtils.isNotBlank(release)) {
                config.commonTags("git_release", release);
            }
        };
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }
}