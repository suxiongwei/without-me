package com.sxw.learn.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterDemo {
    public static void main(String[] args) {
        // 元素的总数量
        int total = 1000000;
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total, 0.0002);
        // 初始化 1000000 条元素到布隆过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        // 判断值是否在布隆过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++){
            if (bf.mightContain("" + i)){
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);
        /**
         * 输出到结果为：1000309
         * 很明显以上的输出结果已经出现了误报，因为相比预期的结果多了 309 个元素，误判率为：309/(1000000 + 10000) * 100 ≈ 0.030594059405940593
         * 如果要提高匹配精度的话，我们可以在创建布隆过滤器的时候设置误判率 fpp：
         * BloomFilter<CharSequence> bf = BloomFilter.create(
         *   Funnels.stringFunnel(Charsets.UTF_8), total, 0.0002
         * );
         * 默认到误判率为0.03
         * 配置了误判率后输出：
         * 已匹配数量 1000003
         *
         * 通过观察以上的结果，可知误判率 fpp 的值越小，匹配的精度越高。当减少误判率 fpp 的值，需要的存储空间也越大，所以在实际使用过程中需要在误判率和存储空间之间做个权衡
         */
    }
}
