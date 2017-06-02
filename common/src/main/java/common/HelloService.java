package common;

/**
 * Service interface in a common library.
 *
 * To be implemented by the server and called by the client.
 *
 * Spring remoting will automatically generate proxy for the client and exporter for the server
 * based on this interface.
 *
 * This occurs in the applicationContext.xml files in both server and client.
 */
public interface HelloService {

    String sayHello();
}
