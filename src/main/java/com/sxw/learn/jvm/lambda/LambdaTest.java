package com.sxw.learn.jvm.lambda;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest {
    /**
     * https://mp.weixin.qq.com/s/qVpbnmrzhCwp9oYuOq3VgQ
     * @param args
     */
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

        // 数组转集合
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(res));

        // 将数组元素 存储到 List 中
        int[] arr = {1, 2, 3, 4, 5};
        // boxed的作用就是将int类型的stream转成了Integer类型的Stream
        IntStream.of(arr).boxed().collect(Collectors.toList());

        // 统计数组元素中的个数,传统的方法借助map实现，较为冗余
        String[] arr1 = {"a", "c", "a", "b", "d", "c"};
        // 第一个参数代表将arr中的每一个元素作为Map中的key，
        // 第二个参数代表每一个key所对应的value，在这里每一个元素都对应个数1，
        // 第三个参数代表，如果存在相同的key，该如何进行合并，这里通过使用Integer::sum，代表将具有相同key的元素进行合并时，其value进行相加，这样便实现了每个元素个数的统计。
        Stream.of(arr1)
                .collect(Collectors.toMap(k -> k, k -> 1, Integer::sum))
                .forEach((k, v) -> System.out.println(k + " : " + v));

        // 基本数据类型的数组自定义排序
        int[] arr2 = {1, 5, 9, 7, 2, 3, 7, -1, 0, 3};
        int[] res1 = IntStream.of(arr2)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(res1));

        // 统计数组中前 k 个个高频元素
        int[] nums = {1, 5, 9, 7, 2, 3, 7, -1, 0, 3};
        int k = 3;
        int[] res2 = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
        System.out.println(Arrays.toString(res2));

        // Collector收集器的叠加嵌套
        // 按照子公司+部门双层维度，统计各个部门内的人员数
//        Map<String, Map<String, Long>> resultMap = getAllEmployees().stream()
//                .collect(Collectors.groupingBy(Employee::getSubCompany,
//                        Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
//        System.out.println(resultMap);

        // map() 方法修改内容
//        List<Student> studentNames = students.stream().map(student -> {
//            if ("汤霖".equals(student.getName())) {
//                student.setChineseScore(90);
//            }
//            return student;
//        }).collect(Collectors.toList());

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
