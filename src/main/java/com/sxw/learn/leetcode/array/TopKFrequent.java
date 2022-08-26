package com.sxw.learn.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [题目]: 给定String类型的数组strArr，再给定整数k，请严格按照排名顺序打印出现次数前k名的字符串。
 * [要求]：如果strArr长度为N，时间复杂度请达到O(Nlogk)
 *
 * [解题思路]: 先建立词频表，然后借助堆(大根堆和小根堆都可以)
 * 大根堆 建立完成之后，弹出两个
 * 小根堆(不能超过两个)：体现的是到目前为止，出现次数最大的前两个，按小根堆组织(堆顶的值相当于门槛，如果新来的值比门槛大，那就把门槛干掉，把自己加入)
 * <span>可以看出大根堆占的空间多</span>
 *
 * 可以直接写个lambda
 */
public class TopKFrequent {
    // 用来存储字符串及其出现的次数，也可以直接使用map
    static class Node{
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    // 大根堆解法
    public static List<String> topKFrequent(String[] words, int k){
        List<String> result = new ArrayList<>(k);
        Map<String, Integer> strAndTimesMap = Arrays.stream(words).collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));// 构建词频表
        PriorityQueue<Node> bigQueue = new PriorityQueue<>(words.length, (o1, o2) -> {
            if (o1.times == o2.times) {
                return o1.str.compareTo(o2.str);// 次数相同，按照字典序排序
            } else {
                return o2.times - o1.times;
            }
        });
        strAndTimesMap.entrySet().forEach(i -> bigQueue.add(new Node(i.getKey(), i.getValue())));
        while (!bigQueue.isEmpty() && k-- > 0){
            result.add(bigQueue.poll().str);
        }
        return result;
    }

    // 小根堆解法
    public static List<String> topKFrequent1(String[] words, int k){
        List<String> result = new ArrayList<>(k);
        Map<String, Integer> strAndTimesMap = Arrays.stream(words).collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));// 构建词频表
        PriorityQueue<Map.Entry<String, Integer>> smallQueue = new PriorityQueue<>(words.length, (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o2.getKey().compareTo(o1.getKey());// 次数相同，按照字典序排序
            } else {
                return o1.getValue() - o2.getValue();
            }
        });
        strAndTimesMap.entrySet().forEach(i -> {
            if (smallQueue.size() >= k){
                if (i.getValue() >= smallQueue.peek().getValue()){
                    smallQueue.offer(i);
                    smallQueue.poll();
                }
            }else {
                smallQueue.offer(i);
            }
        });
        while (!smallQueue.isEmpty()) result.add(smallQueue.poll().getKey());// 由于是小根堆，所以需要逆序
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
//        String[] strArr = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] strArr = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        List<String> strings = topKFrequent1(strArr, k);
        strings.forEach(System.out::println);
    }
}
