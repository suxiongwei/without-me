package com.sxw.learn.leetcode.dp;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * [题目]: 派对的最大快乐值
 * 整个公司的人员结构可以看作是一棵标准的多叉树。树的头节点是公司唯一的老板，除老板外，每个员工都有唯一的直接上级，叶节点是没有任何下属的基层员工，除基层员工外，每个员工都有一个或多个直接下级，另外每个员工都有一个快乐值。
 * 这个公司现在要办 party，你可以决定哪些员工来，哪些员工不来。但是要遵循如下的原则：
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来。
 * 2.派对的整体快乐值是所有到场员工快乐值的累加。
 * 3.你的目标是让派对的整体快乐值尽量大。
 * 给定一棵多叉树，请输出派对的最大快乐值。
 */
public class MaxHappy {
    public static int maxHappy(Employee boss){
        Info process = process(boss);
        return Math.max(process.buMaxHappy, process.laiMaxHappy);
    }

    public static class Employee{
        public int happy;// 这名员工可以带来的快乐值
        public List<Employee> nexts;// 这名员工有哪些直接下级

        public Employee(int happy) {
            this.happy = happy;
            this.nexts = Lists.newArrayList();
        }

        public Employee(int happy, List<Employee> nexts) {
            this.happy = happy;
            this.nexts = nexts;
        }
    }

    static class Info{
        public int laiMaxHappy;// 来的最大快乐值
        public int buMaxHappy;// 不来的最大快乐值

        public Info(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public static Info process(Employee x){
        if (x.nexts.isEmpty()) return new Info(x.happy, 0);
        int lai = x.happy;
        int bu = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;// 来的话，下级员工只能不来
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);// 不来的话，下级可以来也可以不来
        }
        return new Info(lai, bu);
    }

    //测试
    public static void main(String[] args) {
        Employee head1 = new Employee(1);
        Employee head2 = new Employee(3);
        Employee head3 = new Employee(2);
        Employee head4 = new Employee(5);
        Employee head5 = new Employee(6);
        head1.nexts.add(head2);
        head1.nexts.add(head3);
        head1.nexts.add(head4);
        head1.nexts.add(head5);
        System.out.println(maxHappy(head1));
    }

}
