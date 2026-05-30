package com.smit.rrf.bootstrap.scanner;

import com.smit.rrf.annotations.RestResource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.HashSet;
import java.util.Set;

public class ClassPathResourceScanner {

    public Set<Class<?>> scan(String basePackage) {

        Set<Class<?>> classes = new HashSet<>();

        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter(
                new AnnotationTypeFilter(RestResource.class)
        );

        for (BeanDefinition candidate :
                scanner.findCandidateComponents(basePackage)) {

            try {

                Class<?> clazz =
                        Class.forName(candidate.getBeanClassName());

                classes.add(clazz);

            } catch (ClassNotFoundException ignored) {
            }
        }

        return classes;
    }
}