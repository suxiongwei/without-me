package com.sxw.learn.leetcode;


public class TrieTree {
    public static class TrieNode{
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

    public static class Trie{
        private TrieNode root;

        public Trie(TrieNode root) {
            this.root = new TrieNode();
        }

        public void insert(String word){
            if (word == null) return;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) node.nexts[index] = new TrieNode();
                node.pass++;
                node = node.nexts[index];
            }
            node.end++;
        }


        public void delete(String word){
            // 路过的节点pass--,如果到结尾了,end--，如果在删除的过程中这条路都没有了，直接将next设置为null，也就是删掉下一个节点
            if (search(word) > 0){// 确定树中存在过，才删除
                char[] chars = word.toCharArray();
                int index = 0;
                TrieNode node = root;
                node.pass--;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        // 查询字符串出现过几次
        public int search(String word){
            if (word == null) return 0;
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chars.length; i++){
                index = chars[i] - 'a';
                if (node.nexts[index] == null) return 0;
                node = node.nexts[index];
            }
            return node.end;
        }

        // 在加入的字符串中，有几个是以pre字符串作为前缀的
        public int prefixNumber(String pre){
            if (pre == null) return 0;
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for(int i = 0; i < chars.length; i++){
                index = chars[i] - 'a';
                if (node.nexts[index] == null) return 0;
                node = node.nexts[index];
            }
            return node.pass;
        }



    }
}
