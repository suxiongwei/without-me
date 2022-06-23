package com.sxw.learn.juc.cas;

import org.xnio.AutomaticReference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS靠硬件实现的，从而在硬件层面提升效率，最底层还是交给硬件来保证原子性和可见性
 * 实现方式是基于硬件的汇编指令
 *
 * 核心思想：
 * 比较要更新变量的值V与预期值E，相等才会将V设置为新值N，不相等则自旋
 *
 * 优点：
 * 轻量级
 *
 * 缺点：
 * 极端情况，自旋过多影响开销变大
 * ABA问题
 *
 */
public class CasDemo {

}
