package com.smit.rrf.bootstrap;

import com.smit.rrf.annotations.EnableRestResources;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class RestResourceRegistrar
        implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {

        Map<String, Object> attributes =
                importingClassMetadata.getAnnotationAttributes(
                        EnableRestResources.class.getName()
                );

        if (attributes != null) {

            String[] basePackages =
                    (String[]) attributes.get("basePackages");

            FrameworkContext.setBasePackages(basePackages);
        }

        System.out.println(
                "[RRF] Rest Resource Framework Enabled"
        );
    }
}