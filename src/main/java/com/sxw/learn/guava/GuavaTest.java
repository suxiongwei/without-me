package com.sxw.learn.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GuavaTest {
    public static void main(String[] args) {
        // Multimap 测试
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("key1", 1);
        multimap.put("key1", 2);

        multimap.put("key2", 2);
        System.out.println(multimap.get("key1"));
        System.out.println("Multimap测试结束");

        // HashBasedTable 测试
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("a", "a", 1);
        table.put("a", "b", 2);
        System.out.println(table.get("a", "b"));
        System.out.println("Table测试结束");

        // 测试 ImmutablePair
        Pair<Integer, Integer> pair = new ImmutablePair<>(1, 2);
        System.out.println("left:" + pair.getLeft());
        System.out.println("right:" + pair.getRight());
        System.out.println("Pair测试结束");

        // 测试 Triple
        Triple<Integer, Integer, Integer> triple = new ImmutableTriple<>(1, 2, 3);
        System.out.println(triple.getMiddle());
        System.out.println("Triple测试结束");

        // 测试 CollectionUtils
        List<String> coll1 = Lists.newArrayList("1","2","3");
        List<String> coll2 = Lists.newArrayList("2","3", "5");

        // 交集
        Collection collection = CollectionUtils.retainAll(coll1, coll2);
        System.out.println("交集:" + collection.size());
        System.out.println("交集:" + coll1);
        System.out.println("交集:" + coll2);

        // 并集
        CollectionUtils.union(coll1, coll2);
        // 差集
        CollectionUtils.subtract(coll1, coll2);
        // 判断相等
        CollectionUtils.isEqualCollection(coll1, coll2);

        String txt = "";
        if (Strings.isNullOrEmpty(txt)){
            System.out.println("txt isNullOrEmpty");
        }

        int count = 1;
        Preconditions.checkArgument(count > 0, "must be positive: %s", count);

        List<Integer> eleList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, null);
        String joinStr = Joiner.on("#")  //分隔符
                .skipNulls()  //过滤null元素
                .join(eleList);//要分割的集合
        System.out.println("添加分割符" + joinStr);

        String str="1,2,3,4,5,6,7";
        List<String> stringList = Splitter.on(",")
                .trimResults()
                .splitToList(str);
        System.out.println(stringList);

        // 主要对url的param的编码
        Map<String, String> of = ImmutableMap.of("id", "123", "name", "green");
        String join = Joiner.on("&").withKeyValueSeparator("=").join(of);
        // 运行结果:id=123&name=green
        System.out.println(join);

        String str1 ="id=123&name=green";
        Map<String, String> split = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split(str1);
        // 运行结果:{id=123, name=green}
        System.out.println(split);

        // 测试BiMap
        System.out.println("--------------------测试BIMap-----------------------");
        HashBiMap<String,String> upperToLower = HashBiMap.create();
        upperToLower.forcePut("A","a");
        upperToLower.forcePut("B","b");
        upperToLower.forcePut("C","c");
        //upperToLower.put("D","d");会丢出IllegalArgumentException, 需要用forceput
        upperToLower.forcePut("D","c");

        //用key获取value
        System.out.println(upperToLower.get("D"));  //c

        //用value获取key
        BiMap<String, String> lowerToUpper = upperToLower.inverse();
        System.out.println(lowerToUpper.get("c"));  //D
        System.out.println(upperToLower.get("D"));  //c
    }
}
