package com.dragon;

/**
 * @date: 2024/4/19 08:07
 * @author: ybl
 */
public class JettyWebServer implements WebServer{
    @Override
    public void start() {
        System.out.println("Jetty");
    }
}
