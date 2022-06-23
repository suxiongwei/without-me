package com.sxw.learn.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        val z3 = new User("z3", 18);
        val l4 = new User("l4", 22);
        val w5 = new User("w5", 80);

        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, w5) + "\t" + atomicReference.get().toString());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    String name;
    int age;
}
