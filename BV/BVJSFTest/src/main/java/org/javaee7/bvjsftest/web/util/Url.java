/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.bvjsftest.web.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Masudul Haque
 */
@Constraint(validatedBy = URLValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Url {

    String message() default "{org.javaee7.bvjsftest.web.util.Url}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String protocol() default "";

    String host() default "";

    int port() default -1;
}
