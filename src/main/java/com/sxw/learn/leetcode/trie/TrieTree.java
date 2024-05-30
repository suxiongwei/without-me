package com.sxw.learn.leetcode.trie;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Supplier;

/**
 * Trie字典树工具
 * 用来快速匹配关键词
 */
public class TrieTree {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 词库cache最少100ms失效
     */
    private static final int CACHE_EXPIRE_MIN_MILLS = 100;
    /**
     * 字典树
     */
    private HashMap<Integer, Node> rootMap = new HashMap<>();
    /**
     * 忽略字符
     */
    private Set<Integer> ignoreCharacters = new HashSet<>();
    /**
     * 空结果
     */
    private List<String> EMPTY_RET = Collections.emptyList();
    /**
     * 词库过期时间
     */
    private Integer cacheExpireMills;
    /**
     * 词库提供器
     */
    private Supplier<List<String>> supplier;
    /**
     * 缓存词库加载时间
     */
    private long nextLoadWordsTimestamp = System.currentTimeMillis();

    /**
     * 字符节点
     */
    private static class Node {
        /**
         * 节点字符
         */
        private char c;
        /**
         * 后面的字符节点
         * 使用数字速度更快，因为UTF8最多4字节，可以用整形数字存，用包装类Character会比Integer存慢且占用更多空间
         */
        private HashMap<Integer, Node> nextNodeMap = new HashMap<>();
        /**
         * 关键词字符串
         */
        private String keyword;

        public Node(char c) {
            this.c = c;
        }

        /**
         * 当前节点是否有关键词
         *
         * @return
         */
        public boolean hasKeyword() {
            return keyword != null;
        }

        public HashMap<Integer, Node> getNextNodeMap() {
            return nextNodeMap;
        }


        public String getKeyword() {
            return keyword;
        }

        public Node setKeyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

    /**
     * 忽略字符
     *
     * @param characters
     */
    public void addIgnoreCharacters(Character... characters) {
        if (characters != null && characters.length > 0) {
            for (Character c : characters) {
                ignoreCharacters.add((int) c);
            }
        }
    }

    /**
     * 加载关键词
     *
     * @param words
     */
    public void loadWords(Collection<String> words) {
        words.forEach(this::loadWord);
    }

    /**
     * 加载关键词
     *
     * @param word
     */
    public void loadWord(String word) {
        word = removeIgnoreCharacters(word);
        if (isNotBlank(word)) {
            char firstChar = word.charAt(0);
            int key = firstChar;
            Node current = rootMap.computeIfAbsent(key, k -> new Node(firstChar));
            for (int i = 1; i < word.length(); i++) {
                key = word.charAt(i);
                current = current.getNextNodeMap().computeIfAbsent(key, k -> new Node((char) k.intValue()));
            }
            // 设置末尾
            current.setKeyword(word);
        }
    }

    /**
     * 字符串为空
     *
     * @param s
     * @return
     */
    public boolean isBlank(String s) {
        return s == null || s.length() == 0;
    }

    /**
     * 字符串不为空
     *
     * @param s
     * @return
     */
    public boolean isNotBlank(String s) {
        return s != null && s.length() > 0;
    }

    /**
     * 是否有完全一致的
     *
     * @param str 给定字符串
     * @return
     */
    public boolean contains(String str) {
        if (isBlank(str)) {
            return false;
        }
        preMatch();
        str = removeIgnoreCharacters(str);
        Node current = rootMap.get((int) str.charAt(0));
        if (current == null) {
            return false;
        }
        if (str.length() == 1 && current.hasKeyword()) {
            return true;
        }
        for (int i = 1; i < str.length(); i++) {
            // 获取当前字符的node
            current = current.getNextNodeMap().get((int) str.charAt(i));
            if (current == null) {
                return false;
            }
        }
        return current.hasKeyword();
    }

    /**
     * 给出的字符串是否包含了词库关键词
     *
     * @param str 给定字符串
     * @return
     */
    public boolean match(String str) {
        preMatch();
        str = removeIgnoreCharacters(str);
        return matchAndGetKeywords(str, true).size() > 0;
    }

    /**
     * 获取给出的字符串包含的所有关键词
     *
     * @param str
     * @return
     */
    public List<String> matchAndGetKeywords(String str) {
        preMatch();
        str = removeIgnoreCharacters(str);
        return matchAndGetKeywords(str, false);
    }

    /**
     * 获取给出的字符串包含的第一个关键词
     *
     * @param str
     * @return
     */
    public String matchAndGetKeyword(String str) {
        preMatch();
        str = removeIgnoreCharacters(str);
        List<String> ret = matchAndGetKeywords(str, true);
        return ret.size() > 0 ? ret.get(0) : null;
    }

    /**
     * 获取给出的字符串包含的关键词
     *
     * @param str        给定字符串
     * @param findReturn 是否找到就返回
     * @return
     */
    private List<String> matchAndGetKeywords(String str, boolean findReturn) {
        if (isBlank(str)) {
            return EMPTY_RET;
        }
        List<String> ret = EMPTY_RET;
        // 开头
        for (int i = 0; i < str.length(); i++) {
            List<String> matchStringList = matchStartWith(str, i, findReturn);
            if (matchStringList.size() > 0) {
                if (findReturn) {
                    // 找到就返回
                    return matchStringList;
                } else if (ret == EMPTY_RET) {
                    // 空集合
                    ret = matchStringList;
                } else {
                    // 已有匹配上的
                    ret.addAll(matchStringList);
                }
            }
        }
        return ret;
    }

    public HashMap<Integer, Node> getRootMap() {
        return rootMap;
    }

    public TrieTree setRootMap(HashMap<Integer, Node> rootMap) {
        this.rootMap = rootMap;
        return this;
    }

    public TrieTree setIgnoreCharacters(Set<Integer> ignoreCharacters) {
        this.ignoreCharacters = ignoreCharacters;
        return this;
    }

    /**
     * 从str某个位置开始匹配
     *
     * @param str
     * @param start
     * @param findReturn
     * @return
     */
    private List<String> matchStartWith(String str, int start, boolean findReturn) {
        Node current = rootMap.get((int) str.charAt(start));
        if (current == null) {
            return EMPTY_RET;
        }
        List<String> ret = EMPTY_RET;
        if (current.hasKeyword()) {
            ret = new LinkedList<>();
            ret.add(current.getKeyword());
            if (findReturn) {
                return ret;
            }
        }
        for (int i = start + 1; i < str.length(); i++) {
            current = current.getNextNodeMap().get((int) str.charAt(i));
            if (current == null) {
                // 不再匹配
                break;
            } else if (current.hasKeyword()) {
                // 当前节点匹配上了
                if (ret == EMPTY_RET) {
                    ret = new LinkedList<>();
                }
                ret.add(current.getKeyword());
                if (findReturn) {
                    return ret;
                }
            }
        }
        return ret;
    }

    /**
     * 移除被忽略的字符
     *
     * @param str
     * @return
     */
    public String removeIgnoreCharacters(String str) {
        if (isBlank(str) || ignoreCharacters.size() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int key = str.charAt(i);
            if (!ignoreCharacters.contains(key)) {
                stringBuilder.append((char) key);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(rootMap);
    }

    /**
     * 缓存化加载词库
     *
     * @param supplier
     * @param cacheExpireMills
     */
    public void setCacheableLoadWords(Supplier<List<String>> supplier, int cacheExpireMills) {
        if (supplier == null || cacheExpireMills < CACHE_EXPIRE_MIN_MILLS) {
            throw new IllegalArgumentException("supplier is null or cache expire mills less than " + CACHE_EXPIRE_MIN_MILLS + "ms");
        }
        this.cacheExpireMills = cacheExpireMills;
        this.supplier = supplier;
    }

    /**
     * 检查缓存的词库
     */
    public void checkCacheWords() {
        long now = System.currentTimeMillis();
        if (supplier != null && cacheExpireMills != null && now >= nextLoadWordsTimestamp) {
            // 更新下次更新缓存词库时间
            nextLoadWordsTimestamp = now + cacheExpireMills;
            // 执行更新词库
            try {
                // 拿到词库
                List<String> words = supplier.get();
                if (words != null) {
                    // 创建新树，保障当前树一直可用
                    TrieTree newTree = new TrieTree();
                    // 同步忽略的字符
                    if (ignoreCharacters.size() > 0) {
                        newTree.setIgnoreCharacters(ignoreCharacters);
                    }
                    // 生成字典树并替换当前对象的树
                    newTree.loadWords(words);
                    rootMap = newTree.getRootMap();
                    // 去除互相的链接、让垃圾回收能回收新树
                    newTree.setIgnoreCharacters(null);
                    newTree.setRootMap(null);
                }
            } catch (Exception e) {
                logger.error("checkCacheWords update words error", e);
            }
        }
    }

    /**
     * 匹配前处理
     */
    public void preMatch() {
        // 检查缓存词库
        checkCacheWords();
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        Set<String> brandsSet = Sets.newHashSet("奥斯曼", "奥斯曼卫浴", "奥普", "记录");
        trieTree.loadWords(brandsSet);

        System.out.println(trieTree.contains("奥斯曼"));

//        List<String> matchAndGetKeywords = trieTree.matchAndGetKeywords("奥斯曼卫");
        List<String> matchAndGetKeywords = trieTree.matchAndGetKeywords("浪漫生活的记录者");


        System.out.println("matchAndGetKeywords:" + matchAndGetKeywords);
    }
}
