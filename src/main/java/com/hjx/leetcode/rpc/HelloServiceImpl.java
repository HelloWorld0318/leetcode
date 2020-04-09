package com.hjx.leetcode.rpc;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + " say hello";
    }
}
