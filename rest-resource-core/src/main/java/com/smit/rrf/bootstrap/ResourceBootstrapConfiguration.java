package com.smit.rrf.bootstrap;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceBootstrapConfiguration {

    @Bean
    public ApplicationRunner resourceRunner(
            ResourceBootstrapper bootstrapper) {

        return args -> {

            String[] packages =
                    FrameworkContext.getBasePackages();

            if (packages == null) {
                return;
            }

            for (String basePackage : packages) {
                bootstrapper.bootstrap(basePackage);
            }
        };
    }
}