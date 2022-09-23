package com.sxw.learn.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * 使用Curator框架实现分布式锁
 * https://mp.weixin.qq.com/s/jn4LkPKlWJhfUwIKkp3KpQ
 */
public class CuratorLock {
    private String rootNode = "/locks";
    // zookeeper server 列表
    private String connectString = "localhost:2181";
    // connection 超时时间
    private int connectionTimeout = 2000;
    // session 超时时间
    private int sessionTimeout = 2000;

    // 测试
    private void test() {
        // 创建分布式锁 1
        final InterProcessLock lock1 = new InterProcessMutex(getCuratorFramework(), rootNode);
        // 创建分布式锁 2
//        final InterProcessLock lock2 = new InterProcessMutex(getCuratorFramework(), rootNode);

        new Thread(() -> {
            // 获取锁对象
            try {
                System.out.println(Thread.currentThread().getName() + "开始获取锁");
                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + "第一次获取锁成功");
                // 测试锁重入
                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + "第二次获取锁成功");

                TimeUnit.SECONDS.sleep(5);

                lock1.release();
                System.out.println(Thread.currentThread().getName() + "第一次释放锁");
                TimeUnit.SECONDS.sleep(5);

                lock1.release();
                System.out.println(Thread.currentThread().getName() + "第二次释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"线程-A").start();

        new Thread(() -> {
            // 获取锁对象
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "开始获取锁");

                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + "第一次获取锁成功");
                // 测试锁重入
                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + "第二次获取锁成功");

                TimeUnit.SECONDS.sleep(1);

                lock1.release();
                System.out.println(Thread.currentThread().getName() + "第一次释放锁");
                lock1.release();
                System.out.println(Thread.currentThread().getName() + "第二次释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程-B").start();
    }

    // 分布式锁初始化
    public CuratorFramework getCuratorFramework (){
        //重试策略，初试时间 3 秒，重试 3 次
        RetryPolicy policy = new ExponentialBackoffRetry(3000, 3);
        //通过工厂创建 Curator
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .connectionTimeoutMs(connectionTimeout)
                .sessionTimeoutMs(sessionTimeout)
                .retryPolicy(policy).build();
        //开启连接
        client.start();
        System.out.println("zookeeper 初始化完成...");
        return client;
    }

    public static void main(String[] args) {
        new CuratorLock().test();
    }
}
