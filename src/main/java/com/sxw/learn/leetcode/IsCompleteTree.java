package com.sxw.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-30 2:19 下午
 */
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        List<Anode> nodes = new ArrayList<>();
        nodes.add(new Anode(root, 1));
        int i = 0;
        while (i < nodes.size()){
            Anode anode = nodes.get(i++);
            if (anode.node != null){
                nodes.add(new Anode(anode.node.left, anode.code * 2));
                nodes.add(new Anode(anode.node.right, anode.code * 2 + 1));
            }
        }
        return nodes.get(i - 1).code == nodes.size();
    }

    class Anode{
        TreeNode node;
        int code;
        public Anode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
}
