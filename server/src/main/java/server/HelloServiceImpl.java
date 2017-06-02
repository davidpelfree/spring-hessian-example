package server;

import common.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Hello from HelloService!";
    }

}
