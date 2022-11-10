package com.sxw.learn.leetcode.trie;

/**
 * [题目]: 实现Trie(前缀树)
 * [题目描述]:
 * 查询一个字符串是否存在（没什么特殊的，map一样可以做到）
 * 查询以特定字符串作为前缀的数量（查看p值就很容易的得到）
 * 根节点的p值代表有多少空串，也代表当前树有多少个字符串
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) return;
        TrieNode node = root;
        node.pass++;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node.pass++;
            node = node.nexts[index];
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null) return false;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return node.end > 0;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return true;
    }

    public static class TrieNode {
        public int pass;// 经过了多少节点
        public int end;// 有多少字符串是以当前节点为结尾的
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            // nexts[0] == null 没有走向 `a` 的路
            // nexts[0] != null 有走向 `a` 的路
            // ...
            // nexts[25] != null 有走向 `z` 的路
            this.nexts = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app")); // 返回 False
        System.out.println(trie.startsWith("app"));// 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));// 返回 True
    }
}
