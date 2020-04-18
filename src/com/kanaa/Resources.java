package com.kanaa;

/**
 * @author Alexander Kanunnikov
 */

public class Resources {

    public static String path(String fileName) {
        return System.getProperty("user.dir")+"\\resources\\"+fileName;
    }

}