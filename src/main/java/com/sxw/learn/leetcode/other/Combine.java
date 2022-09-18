package com.sxw.learn.leetcode.other;

import java.util.*;

/**
 * [题目]: 组合(77)
 * [题目描述]:
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * [解题思路]: 回溯算法 + 剪枝
 * 重点概括：
 * 如果解决一个问题有多个步骤，每一个步骤有多种方法，题目又要我们找出所有的方法，可以使用回溯算法；
 * 回溯算法是在一棵树上的 深度优先遍历（因为要找所有的解，所以需要遍历）；
 * 组合问题，相对于排列问题而言，不计较一个组合内元素的顺序性（即 [1, 2, 3] 与 [1, 3, 2] 认为是同一个组合），因此很多时候需要按某种顺序展开搜索，这样才能做到不重不漏。
 * 回溯算法首先需要画出递归树，不同的树决定了不同的代码实现。
 *
 * 常规的回溯方式搜索起点是从1到n，事实上，如果 n = 7, k = 4，从 5 开始搜索就已经没有意义了
 * 这是因为：即使把 5 选上，后面的数只有 6 和 7，一共就 3 个候选数，凑不出 4 个数的组合。
 * 因此，搜索起点有上界，这个上界通过举例子可以推理出：搜索起点的上界 = n - (k - path.size()) + 1
 * 具体题解：https://leetcode.cn/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) return res;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);// 从 1 开始是题目的设定
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
//        for (int i = begin; i <= n; i++) {// 这里可以通过剪枝进行优化，如下
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);// 向路径变量里添加一个数
            dfs(n, k, i + 1, path, res);// 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            path.removeLast();// 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
        }
    }

    public static void main(String[] args) {
        Combine solution = new Combine();
        List<List<Integer>> combine = solution.combine(4, 2);
        combine.forEach(e -> System.out.println(e));
    }
}
