package com.hjx.leetcode.rpc;

public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = RpcFramework.referenceService(HelloService.class, "127.0.0.1", 20880);
        System.out.println(helloService.sayHello("tom"));
    }

}
