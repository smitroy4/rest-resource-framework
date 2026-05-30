package com.smit.rrf.bootstrap;

public final class FrameworkContext {

    private static String[] basePackages;

    private FrameworkContext() {
    }

    public static void setBasePackages(String[] packages) {
        basePackages = packages;
    }

    public static String[] getBasePackages() {
        return basePackages;
    }
}