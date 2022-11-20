package com.sxw.learn.leetcode.unionfind;

import java.util.*;

/**
 * [题目]: 省份数量(547)
 * [题目描述]:
 * 有n个城市，其中一些彼此相连，另一些没有相连。如果城市a与城市b直接相连，且城市b与城市c直接相连，那么城市a与城市c间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例：
 * 输入：isConnected =
 * {
 * {1,1,0},
 * {1,1,0},
 * {0,0,1}
 * }
 * 输出：2
 * [解题思路]:
 * 并差集
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int M = isConnected.length;
        int N = isConnected[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) list.add(i);
        UnionFindSet<Integer> unionFind = new UnionFindSet(list);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (isConnected[i][j] == 1) {
                    if (!unionFind.isSameSet(i, j)){
                        unionFind.union(unionFind.elementMap.get(i), unionFind.elementMap.get(j));
                    }
                }
            }
        }
        // 更新元素的代表元素，比如 0 -> 1  3 -> 0 更新后 3 -> 1
        for (int i = 0; i < M; i++) {
            unionFind.findHead(unionFind.elementMap.get(i));
        }
        Set<Element> elementSet = new HashSet<>();
        unionFind.fatherMap.entrySet().forEach(e -> elementSet.add(e.getValue()));
        return elementSet.size();
    }

    // 样本进来会先包装一下，叫做元素
    public static class Element<V> {
        public V value;
        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        // key：某个元素，value：该元素的父
        public HashMap<Element<V>, Element<V>> fatherMap;
        // key：某个集合的代表元素，value：该集合的大小
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            if (!elementMap.containsKey(a) || !elementMap.containsKey(b)) return false;
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }

        public void union(Element<V> a, Element<V> b) {
            if (elementMap.containsKey(a.value) && elementMap.containsKey(b.value)) {
                Element<V> aF = findHead(a);// a的代表节点
                Element<V> bF = findHead(b);// b的代表节点
                if (aF != bF) {
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(small) + sizeMap.get(big));
                    sizeMap.remove(small);
                }
            }
        }

        /**
         * 给定一个元素，一直往上找，返回这个元素的代表元素
         * findHead调用的不频繁，时间复杂度不好下定论，调用的很频繁，达到O(N)的水平，那么findHead的时间复杂度就是O(1)
         */
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            // 代表元素的父亲元素就是自己，所以当自己=自己的父则证明走到了代表元素
            while (element != fatherMap.get(element)) {
                path.add(element);
                element = fatherMap.get(element);
            }
            while (!path.empty()) {
                // 链可能比较长,但是在路径压缩(打扁平)之后,时间复杂度就变成了O(1),具体实现:在查询的过程中,把沿途的每个元素都指向代表元素就可以了
                fatherMap.put(path.pop(), element);
            }
            return element;
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        FindCircleNum solution = new FindCircleNum();
        int circleNum = solution.findCircleNum(isConnected);
        System.out.println(circleNum);
    }
}
