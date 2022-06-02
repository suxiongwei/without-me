package com.sxw.learn.java.future;
/**
 * Future 缺点：
 *  对于结果的获取不是很友好，只能通过轮询或者阻塞的方式得到任务的结果，因此引出了CompletableFuture
 *
 * CompletableFuture
 *  对于简单的需求使用Future可以,复杂的需求用CompletableFuture
 *  Future get()方法在计算完成之前一直处于阻塞状态，辅助以isDone()方法容易耗费CPU资源
 *  对于真正的异步任务我们希望可以使用回调函数，在Future结束后自动调用，这样就不用等待结果
 *  同时，阻塞的方式和异步编程的设计理念相违背，而轮询也会无谓的耗费CPU资源，因此
 *  JDK8 引出了CompletableFuture
 *
 *  CompletableFuture 提供了一种类似观察者模式的机制，可以让任务执行完成之后通知监听的一方
 *
 */