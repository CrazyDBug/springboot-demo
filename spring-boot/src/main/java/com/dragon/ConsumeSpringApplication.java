package com.dragon;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

/**
 * @date: 2024/4/19 07:04
 * @author: ybl
 */
public class ConsumeSpringApplication {
    /**
     * 传入配置类 注册给spring容器
     *
     * @param clazz
     */
    public static void run(Class clazz) {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(clazz);
        context.refresh();
        // 启动tomcat
//        startTomcat(context);

        // 需要根据依赖判断使用Tomcat还是Jetty
        WebServer webServer = getWebServer(context);
        webServer.start();
    }

    private static WebServer getWebServer(WebApplicationContext context) {
        // tomcat&jetty选择
        // 从Spring容器获取替换if else
        Map<String, WebServer> webServers = context.getBeansOfType(WebServer.class);
        if (webServers.isEmpty() || webServers.size() > 1) {
            throw new RuntimeException();
        }
        return webServers.values().stream().findFirst().get();

    }

    public static void startTomcat(WebApplicationContext applicationContext) {

        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8081);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }


}