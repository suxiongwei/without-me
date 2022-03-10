package com.sxw.learn.java.lambda;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        // 判断真假
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("9龙", 23, 175);
        System.out.println("9龙的身高高于185吗？：" + predicate.test(student.getStature()));

        // 消费信息
        Consumer<String> consumer = System.out::println;
        consumer.accept("命运由我不由天");

        // 将T 转换为 R，提供转换功能
        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);

        // 生产功能
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());

        // 一元操作
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);

        // 二元操作
        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2, 3);
        System.out.println(integer);

        test(() -> "我是一个演示的函数式接口");

        // 字符串拼接
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        String joinName = students.stream().map(Student::getName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(joinName);

        // flatMap 将多个Stream合并为一个Stream
        // 调用Stream.of的静态方法将两个list转换为Stream，再通过flatMap将两个流合并为一个。
        List<Student> studentList = Stream.of(students,
                Lists.newArrayList(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        System.out.println(studentList);

        // 转换成块 将其分解成两个集合
        Map<Boolean, List<Student>> listMap = students.stream().collect(
                Collectors.partitioningBy(e -> e.getAge() > 30));
        // map的key 可选值为 true/false 为了区分为两个集合
        listMap.forEach((k,v) -> System.out.println("key:" + k + ",value" + v));
    }

    /**
     * 演示自定义函数式接口使用
     *
     * @param worker
     */
    public static void test(Worker worker) {
        String work = worker.work();
        System.out.println(work);
    }

    public interface Worker {
        String work();
    }
}
