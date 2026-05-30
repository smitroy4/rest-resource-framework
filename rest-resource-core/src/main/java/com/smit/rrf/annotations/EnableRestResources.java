package com.smit.rrf.annotations;

import com.smit.rrf.bootstrap.RestResourceRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RestResourceRegistrar.class)
public @interface EnableRestResources {

    String[] basePackages() default {};
}