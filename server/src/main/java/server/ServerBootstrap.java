package server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

public class ServerBootstrap {

    private static final int PORT = 8080; // TODO read from config

    public static void main(String... args) throws Exception {

        Server server = new Server(PORT);
        Handler servletContextHandler = null;
        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }

}
