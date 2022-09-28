package com.example.gccoffee.model;

import java.lang.annotation.Annotation;

public enum Category implements jdk.jfr.Category {
    COFFEE_BEAN_PACKAGE;

    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
