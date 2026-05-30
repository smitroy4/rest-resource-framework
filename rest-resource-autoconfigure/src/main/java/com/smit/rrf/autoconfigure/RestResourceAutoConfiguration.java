package com.smit.rrf.autoconfigure;

import com.smit.rrf.bootstrap.RepositoryBootstrapper;
import com.smit.rrf.bootstrap.ResourceBootstrapper;
import com.smit.rrf.bootstrap.factory.RepositoryDefinitionFactory;
import com.smit.rrf.bootstrap.factory.ResourceDefinitionFactory;
import com.smit.rrf.bootstrap.scanner.ClassPathResourceScanner;
import com.smit.rrf.bootstrap.scanner.RepositoryScanner;
import com.smit.rrf.config.RestResourceProperties;
import com.smit.rrf.mapper.ModelMapperResourceMapper;
import com.smit.rrf.mapper.ResourceMapper;
import com.smit.rrf.registry.RepositoryRegistry;
import com.smit.rrf.registry.ResourceRegistry;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class RestResourceAutoConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ResourceMapper resourceMapper(ModelMapper modelMapper) {
        return new ModelMapperResourceMapper(modelMapper);
    }

    @Bean
    public ResourceRegistry resourceRegistry() {
        return new ResourceRegistry();
    }

    @Bean
    public RestResourceProperties restResourceProperties() {
        return new RestResourceProperties();
    }

    @Bean
    public ClassPathResourceScanner classPathResourceScanner() {
        return new ClassPathResourceScanner();
    }

    @Bean
    public ResourceDefinitionFactory resourceDefinitionFactory() {
        return new ResourceDefinitionFactory();
    }

    @Bean
    public ResourceBootstrapper resourceBootstrapper(
            ClassPathResourceScanner scanner,
            ResourceDefinitionFactory factory,
            ResourceRegistry registry) {

        return new ResourceBootstrapper(
                scanner,
                factory,
                registry
        );

    }

    @Bean
    public RepositoryRegistry repositoryRegistry() {
        return new RepositoryRegistry();
    }

    @Bean
    public RepositoryScanner repositoryScanner() {
        return new RepositoryScanner();
    }

    @Bean
    public RepositoryDefinitionFactory repositoryDefinitionFactory() {
        return new RepositoryDefinitionFactory();
    }

    @Bean
    public RepositoryBootstrapper repositoryBootstrapper(
            RepositoryScanner scanner,
            RepositoryDefinitionFactory factory,
            RepositoryRegistry registry) {

        return new RepositoryBootstrapper(
                scanner,
                factory,
                registry
        );
    }

}