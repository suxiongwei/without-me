package com.sxw.learn.redis.resp;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-04 9:59 下午
 */
public class RespVM {
    // 模拟redis服务器，用于模拟拦截Redis客户端的消息
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket serverSocket = new ServerSocket(6378);
        Socket socket = serverSocket.accept();
        byte[] chars = new byte[64];
        socket.getInputStream().read(chars);

        System.out.println(new String(chars));

//        socket.close();
//        serverSocket.close();
    }
}
