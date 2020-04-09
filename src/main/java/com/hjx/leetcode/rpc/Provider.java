package com.hjx.leetcode.rpc;

public class Provider {

    public static void main(String[] args) throws Exception {
        final HelloService helloService = new HelloServiceImpl();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcFramework.exportService(helloService, 20880);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
