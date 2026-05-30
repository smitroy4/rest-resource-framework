package com.smit.rrf.autoconfigure;

import com.smit.rrf.config.RestResourceProperties;
import com.smit.rrf.mapper.ModelMapperResourceMapper;
import com.smit.rrf.mapper.ResourceMapper;
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

}