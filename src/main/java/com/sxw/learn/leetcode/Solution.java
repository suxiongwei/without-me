package com.sxw.learn.leetcode;

import lombok.SneakyThrows;

import java.util.*;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-01-21 2:09 下午
 */
public class Solution {
    /**
     * 实现 Sunday 匹配
     *
     * @param origin 原始串
     * @param aim 模式串
     * @return
     */
    public int strStr(String origin, String aim){
        if (origin == null || aim == null){
            return 0;
        }
        if (origin.length() < aim.length()){
            return -1;
        }
        // 目标串匹配索引
        int originIndex = 0;
        // 模式串匹配索引
        int aimIndex = 0;
        // 成功匹配完成的终止条件 所有aim均匹配完
        while (aimIndex < aim.length()){
            // 针对origin已匹配完，但aim未匹配完的情况进行处理
            if (originIndex > origin.length() - 1){
                return -1;
            }
            if (origin.charAt(originIndex) == aim.charAt(aimIndex)){
                originIndex ++;
                aimIndex ++;
            }else {
                // originIndex - aimIndex是因为假如已经匹配到部分字符符合 aim 串进行了移动
                int nextCharIndex = aim.length() + originIndex - aimIndex;
                // 判断下一个目标字符（上面图里的那个绿框框）是否存在。
                if (nextCharIndex < origin.length()){
                    int step = aim.lastIndexOf(origin.charAt(nextCharIndex));
                    if (step == -1){
                        // 不存在的话，设置到目标字符的下一个字符，然后会以这个计算新的 nextIndex
                        originIndex = nextCharIndex + 1;
                    }else {
                        // 存在的话 模式串需要移动 step，也就是原始串的index = nextCharIndex - step
                        originIndex = nextCharIndex - step;
                    }
                    //模式串总是从第一个开始匹配
                    aimIndex = 0;
                }else {
                    return -1;
                }
            }
        }
        // 模式串总是从第一个开始匹配 所以在不匹配到时候一直是0 只有当匹配到的时候，才会自增，所以originIndex - aimIndex 也可以理解为originIndex - aim.length()
        return originIndex - aimIndex;
    }

    public void printNumbers(int n) {
        //声明字符数组,用来存放一个大数
        char[] number = new char[n];
        // 数组填充 都置为 '0'
        Arrays.fill(number, '0');
        while (!incrementNumber(number)) {
            saveNumber(number); //存储数值
        }
    }

    private boolean incrementNumber(char[] number) {
        //循环体退出标识
        boolean isBreak = false;
        //进位标识
        int carryFlag = 0;
        int l = number.length;
        for (int i = l - 1; i >= 0; i--) {
            //取第i位的数字转化位int
            int nSum = number[i] - '0' + carryFlag;
            if (i == l - 1) {
                //最低位加1
                ++nSum;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isBreak = true;
                } else {
                    // 进位之后减10，并把进位标识设置为1
                    nSum -= 10;
                    carryFlag = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isBreak;
    }

    private void saveNumber(char[] number) {
        boolean isBegin0 = true;
        for (char c : number) {
            if (isBegin0 && c != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                // 到这里并没有继续往下实现一个存储数组的版本，是因为原题其实就是要求打印数值。
                // 这道题目在leetcode上被改动成返回int数组的形式，也只是为了测试方便，
                // 本身leetcode并没有提供对应的大数测试样例，也是担心其内存溢出。
                // 总之大家知道本题的考察点所在就可以了。
                System.out.print(c);
            }
        }
        System.out.println();
    }

    /**
     * 回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        // 使用正则替换 但是既然我们都知道哪些字符是幺蛾子（除了字母和数字，都是幺蛾子），
        // 为啥子不直接遍历的时候跳过嘞？这样是不是就不用先做一个替换的预处理了。也就是遇到特殊字符指针直接移动
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int length = s.length();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = length - 1;
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    /**
     * 括号字符串是否有效
     *
     * @param s
     */
    public boolean checkValidString(String s){
        if (s == null || s.equals("")){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        // 左括号集合
        Set<Character> keySet = map.keySet();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            // 第一个字符为右括号 return false
            if (i == 0 && !keySet.contains(tmp)){
                return false;
            }
            // 左括号 入栈
            if (keySet.contains(tmp)){
                stack.push(tmp);
            }
            // stack.isEmpty() 为空的话 tmp != '#' return false
            // map.get(stack.pop()) -> 如果tmp 为 } 它要找 { -> 因此判断 key { 对应的是不是 }
            // stack.isEmpty() 的用来处理 ()[]}([{}]) 这种情况 遇到index4时stack是empty
            else if (tmp != (stack.isEmpty() ? '#' : map.get(stack.pop()))){
                return false;
            }
        }
        // 用来处理这种情况 -> ()[]([{}]){
        return stack.isEmpty();
    }

    /**
     * 使用位运算求和
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        System.out.println("start:" + n);
        boolean b = n > 0 && ((n = n + sumNums(n - 1)) > 0);
        System.out.println("end:" + n);
        return n;
    }

    /**
     * 最后一个单词的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s){
        int count = 0;
        if (s == null || s.equals("")){
            return count;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        for (int i = length - 1; i > 0 ; i--){
            if (chars[i] == ' '){
                if (count == 0){
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public List<TreeNode> traversal(TreeNode root){
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            res.add(node);
            stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * DFS求最大深度
     *
     * @param root
     * @return
     */
    public Integer maxDepth(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        level.push(1);
        Integer maxDepth = 0;

        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            stack.pop();
            Integer temp = level.pop();
            maxDepth = Math.max(temp, maxDepth);
            if (node.right != null) {
                stack.push(node.right);
                level.push(temp + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                level.push(temp + 1);
            }
        }
        return maxDepth;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
                // 比如abcdc right=4时 map.get(c) = 3 此时left = max(0,3) 窗口发生变化
                left = Math.max(map.get(s.charAt(right)), left);
            }
            result = Math.max(result, right - left + 1);
            // 加一是为了直接取到发生重复时 窗口的起点
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int result = 0;
        int[] charIndex = new int[256];
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c], left);
            result = Math.max(result, right - left + 1);
            charIndex[c] = right + 1;
        }

        return result;
    }

    static class TreeNode{
        private Integer value;
        private TreeNode left, right;

        public TreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public TreeNode(Integer value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValid(TreeNode root, Integer min, Integer max){
        if (root == null){
            return true;
        }
        if (min != null && root.value <= min){
            return false;
        }
        if (max != null && root.value >= max){
            return false;
        }

        return isValid(root.left, min, root.value) &&
                isValid(root.right, root.value, max);
    }

    public static TreeNode searchBSF1(TreeNode root, int val){
        while (root != null){
            if (root.value == val) {
                return root;
            } else if (root.value > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    public static TreeNode searchBSF(TreeNode root, int val){
        if (root == null){
            return null;
        }
        if (root.value == val){
            return root;
        }else if(root.value < val){
            return searchBSF(root.right, val);
        }else {
            return searchBSF(root.left, val);
        }
    }

    public int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);

        if (left == right){
            // 说明左子树是一颗满二叉树。因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是2^left - 1，加上当前这个root节点，则正好是2^left。然后只需要再对右子树进行递归统计
            return countNodes(root.right) + (1 << left);
        }else {
            // 说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数加上根节点 -> (1 << right)
            return countNodes(root.left) + (1 << right);
        }
    }

    /**
     * 计算总层数，因为是完全二叉树，所以一直往左子树遍历即可找到总的层级
     *
     * @param root
     * @return
     */
    private int countLevel(TreeNode root){
        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }
        return level;
    }

    /**
     * 按奇偶排序数组
     * @param arr
     * @return
     */
    public int[] sortArrayByParity(int[] arr){
        int j = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                swap(arr, j , i);
                j++;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    @SneakyThrows
    public static void main(String[] args) {
        Class clazz = Class.forName("com.sxw.learn.leetcode.Solution");
        Solution solution = (Solution) clazz.newInstance();

        // Method strStr = clazz.getDeclaredMethod("strStr", String.class, String.class);
        // Integer result = (Integer) strStr.invoke(solution, "Here is a little Hao", "little");
        // System.out.println(result);

        // Method printNumbers = clazz.getDeclaredMethod("printNumbers", int.class);
        // printNumbers.invoke(solution, 3);

        // boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        // System.out.println(palindrome);

        // boolean b = solution.checkValidString("()[]}([{}])");
        // System.out.println(b);

        // int nums = solution.sumNums(3);
        // System.out.println("最终输出：" + nums);

        // int i = solution.lengthOfLastWord("Hello World  ");
        // System.out.println(i);
        // int length = lengthOfLongestSubstring1("abcdc");
        // System.out.println(length);

        // TreeNode node8 = new TreeNode(8, null, null);
        // TreeNode node9 = new TreeNode(9, null, null);
        // TreeNode node10 = new TreeNode(10, null, null);
        //
        // TreeNode node4 = new TreeNode(4, node8, node9);
        // TreeNode node5 = new TreeNode(5, node10, null);
        // TreeNode node6 = new TreeNode(6, null, null);
        // TreeNode node7 = new TreeNode(7, null, null);
        //
        // TreeNode node2 = new TreeNode(2, node4, node5);
        // TreeNode node3 = new TreeNode(3, node6, node7);
        //
        // TreeNode node1 = new TreeNode(1, node2, node3);
        //
        // int i = solution.countNodes(node1);
        // System.out.println(i);
        int[] arr = new int[]{4,3,1,2,4};
        System.out.println(Arrays.toString(solution.sortArrayByParity(arr)));
    }
}
