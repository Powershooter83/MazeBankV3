package me.prouge.mazebank.utils.cdi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FXController {
    String fxmlName() default "";
}
