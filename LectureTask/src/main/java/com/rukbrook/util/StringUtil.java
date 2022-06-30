package com.rukbrook.util;

public final class StringUtil {
    private static final String PERENOS_STROK = "\n\r";

    public static String filter(String text) {
        return text.replaceAll(PERENOS_STROK, "");
    }

    public static String filterAll(String text) {
        String result = text.replaceAll(PERENOS_STROK, "");
        return result.replaceAll("\t", "");
    }
}
