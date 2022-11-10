package com.sxw.learn.leetcode.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集算法
 * 并查集（union-find disjoint sets）是一种十分精巧和简洁的数据结构，主要用于处理不相交集合的合并问题。
 * 正如它的名字一样，并查集的主要的操作有合并（union）与查找（find）。
 * 一些算法也会用到并查集，比如求最小生成树的Kruskal算法。
 *
 * 主要的操作：isSameSet和union操作
 * 希望isSameSet和union都是O(1)
 * 用map和链表都无法实现
 *
 * 空间复杂度是 O(n)
 *
 * 具体的实现思路：
 * 使用往上指的图的结构来指向单链表
 */
public class UnionFind {
    // 样本进来会先包装一下，叫做元素
    public static class Element<V>{
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V>{
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

        public boolean isSameSet(V a, V b){
            if (!elementMap.containsKey(a) || elementMap.containsKey(b)) return false;
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }

        public void union(Element<V> a, Element<V> b){
            if (elementMap.containsKey(a) && elementMap.containsKey(b)){
                Element<V> aF = findHead(a);// a的代表节点
                Element<V> bF = findHead(b);// b的代表节点
                if (aF != bF){
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
            while (element != fatherMap.get(element)){// 代表元素的父亲元素就是自己，所以当自己=自己的父则证明走到了代表元素
                element = fatherMap.get(element);
                path.add(element);
            }
            while (!path.empty()){
                fatherMap.put(path.pop(), element);// 链可能比较长,但是在路径压缩(打扁平)之后,时间复杂度就变成了O(1),具体实现:在查询的过程中,把沿途的每个元素都指向代表元素就可以了
            }
            return element;
        }
    }


}
