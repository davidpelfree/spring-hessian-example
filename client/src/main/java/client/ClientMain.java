package client;

import common.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.RemoteAccessException;

public class ClientMain {

    public static void main(String... args) throws Exception {

        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        final HelloService helloService = (HelloService) context.getBean("helloService");

        System.out.println("--------------------------------------------------------------");
        System.out.println("Calling Hello Service via Spring remoting (Hessian over HTTP):");
        System.out.println("--------------------------------------------------------------");

        try {
            System.out.println("  Remote service said: " + helloService.sayHello());
        } catch (RemoteAccessException e) {
            System.err.println("ERROR: Cannot access remote server. Have you started the server by running ServerBootstrap main class?");
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("Done");
        System.out.println("--------------------------------------------------------------");
    }

}
