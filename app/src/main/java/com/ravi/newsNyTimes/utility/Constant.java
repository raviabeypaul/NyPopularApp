package com.ravi.newsNyTimes.utility;

/**
 * Created by Ravi Paul on 2020-01-27.
 */

public class Constant {

    static {
        System.loadLibrary("native-lib");
    }

    public static native String baseUrl();
    public static native String getApiKey();

    public final static String BASE_URL = baseUrl();
    public final static String API_KEY = getApiKey();

}
