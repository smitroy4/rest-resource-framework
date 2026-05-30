package com.smit.rrf.bootstrap.scanner;

import com.smit.rrf.repository.BaseRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.ResolvableType;

import java.util.HashSet;
import java.util.Set;

public class RepositoryScanner {

    public Set<Class<?>> scan(String basePackage) {

        Set<Class<?>> repositories =
                new HashSet<>();

        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter((metadataReader, metadataReaderFactory)
                -> true);

        for (BeanDefinition candidate :
                scanner.findCandidateComponents(basePackage)) {

            try {

                Class<?> clazz =
                        Class.forName(candidate.getBeanClassName());

                if (clazz.isInterface()
                        && BaseRepository.class.isAssignableFrom(clazz)) {

                    repositories.add(clazz);
                }

            } catch (Exception ignored) {
            }
        }

        return repositories;
    }
}