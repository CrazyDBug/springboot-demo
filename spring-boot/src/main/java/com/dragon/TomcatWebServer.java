package com.dragon;

/**
 * @date: 2024/4/19 08:01
 * @author: ybl
 */
public class TomcatWebServer implements WebServer{
    @Override
    public void start() {
        System.out.println("TomcatWebServer");
    }
}
