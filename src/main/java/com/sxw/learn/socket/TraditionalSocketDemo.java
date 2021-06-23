package com.sxw.learn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-01-27 10:53 下午
 */
public class TraditionalSocketDemo {
    public static void main(String[] args) throws IOException {
        // 当前只能为一个客户端使用
        // 可以通过telnet测试
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务端启动...");

        // while (true){
        //     // 阻塞点1
        //     Socket socket = serverSocket.accept();
        //     System.out.println("有客户端连接进来了...");
        //     InputStream inputStream = socket.getInputStream();
        //
        //     byte[] bytes = new byte[1024];
        //     while (true){
        //         // 阻塞点2
        //         int data = inputStream.read(bytes);
        //         if (data != -1){
        //             String info = new String(bytes, 0, data, "GBK");
        //             System.out.println(info);
        //         }else {
        //             break;
        //         }
        //     }
        // }

        // -----------------------------------------
        // 这种方式可以解决以上只能一个客户端连接的弊端，但是占用线程数太多，会极大的消耗系统资源,线程本身占内存，线程上下文切换也会极大的消耗CPU资源
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            // 会阻塞
            Socket socket = serverSocket.accept();

            executorService.execute(() -> {
                System.out.println("有客户端连接进来了...");
                try (InputStream inputStream = socket.getInputStream()) {
                    System.out.println("执行到这了...");

                    byte[] bytes = new byte[1024];
                    while (true) {
                        // 阻塞点2
                        int data = inputStream.read(bytes);
                        System.out.println("执行到read...");

                        if (data != -1) {
                            String info = new String(bytes, 0, data, "GBK");
                            System.out.println(info);
                        } else {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }
    }
}
