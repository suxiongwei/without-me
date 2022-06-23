package com.sxw.learn.thread;
/**
 * 什么是中断机制？
 * 首先
 * 一个线程不应该由其它线程来中断或者停止，而是应该由线程自行停止
 * 所以 Thread.stop Thread.suspend Thread.resume都已经废弃了
 *
 * 其次
 * 在Java中没有办法立刻停止一条线程，然而停止线程却非常重要，如取消一个耗时操作
 * 因此，Java提供了一种用于手动停止线程的协商机制-中断
 *
 */