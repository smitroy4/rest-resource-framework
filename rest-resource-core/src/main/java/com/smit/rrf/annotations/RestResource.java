package com.smit.rrf.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestResource {

    String path() default "";

    Class<?> dto() default Void.class;

    boolean pageable() default true;

    boolean sortable() default true;

    boolean searchable() default false;
}