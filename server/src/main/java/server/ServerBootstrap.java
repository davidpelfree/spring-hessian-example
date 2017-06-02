package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Starts a local web embedded server (Jetty).
 * Registers Spring DispatcherServlet on URL: "http://localhost:8080/remoting/*"
 *
 * The actual HelloService will be exported on URL: "http://localhost:8080/remoting/HelloService"
 *   as defined in applicationContext.xml
 */
public class ServerBootstrap {

    public static void main(String... args) throws Exception {

        // Define Jetty Web server on "http://localhost:8080"
        final Server jettyWebServer = new Server(8080);


        // Define "http://localhost:8080/remoting" as the base URL
        final ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/remoting");


        // Define that each call to "http://localhost:8080/remoting/*" will be served by Spring DispatcherServlet
        // (which comes from Spring MVC project, not specific to Spring remoting)
        final DispatcherServlet springDispatcherServlet = new DispatcherServlet();

        // Take Spring configuration (beans) from applicationContext.xml:
        springDispatcherServlet.setContextConfigLocation("classpath:applicationContext.xml");

        servletContextHandler.addServlet(new ServletHolder(springDispatcherServlet), "/*");


        // Complete Jetty stuff
        jettyWebServer.setHandler(servletContextHandler);
        jettyWebServer.start();
        jettyWebServer.join();
    }

}
