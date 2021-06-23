package com.sxw.learn.leetcode;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-01-28 8:18 下午
 */
public class NioSocketDemo {
    // 通道选择器（管理器）
    private Selector selector;

    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        this.selector = Selector.open();
        // 注册连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务已启动...");
    }

    public void listenSelector() throws IOException {
        // 轮询监听selector
        while (true){
            // 等待客户端连接
            // select模型 多路复用 这是会阻塞的
            this.selector.select();
            System.out.println("新客户端连接上来了...");
            Iterator<SelectionKey> iteKey = this.selector.selectedKeys().iterator();
            while (iteKey.hasNext()){
                SelectionKey key = iteKey.next();
                iteKey.remove();
                // 处理请求
                handle(key);
            }
        }
    }

    /**
     * 处理客户端请求
     * @param key
     */
    private void handle(SelectionKey key) throws IOException {
        if (key.isAcceptable()){
            // 连接事件，处理客户端连接请求
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            // 设置成非阻塞 否则会报错
            socketChannel.configureBlocking(false);
            // 接受客户端发送的信息需要给通道设置读的权限
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else if (key.isReadable()){
            // 处理读的事件
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readData = socketChannel.read(buffer);
            if (readData > 0){
                String info = new String(buffer.array(), "GBK");
                System.out.println("服务端收到数据："+ info);
            }else {
                System.out.println("客户端关闭了...");
                key.cancel();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 一个线程加一个select就可以为多个进行服务了
        NioSocketDemo nioSocketDemo = new NioSocketDemo();
        nioSocketDemo.initServer(8888);

        nioSocketDemo.listenSelector();
        
    }
}
