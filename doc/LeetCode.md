## Talk Is Cheap, Show Me The Code

### 排序/排序思想的变种问题
- [冒泡排序 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/BubbleSort.java)
- [插入排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/InsertionSort.java)
- [选择排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/SelectionSort.java)
- [归并排序 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/MergeSort.java)
  - [最小和](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SmallSum.java)
  - [求最大值](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/GetMax.java)
- [快速排序 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/QuickSort.java)
```java
// 在L到R范围内进行排序
public static void quickSort(int[] arr, int L, int R){
    // 随机出partition的值
    swap(arr, L + (int) Math.random() * (R - L + 1), R);
    int[] partition = partition(arr, L, R);
    quickSort(arr, L, partition[0] - 1);
    quickSort(arr, partition[1] + 1, R);
}
// 在L到R范围内进行partition，partition的划分值为R位置的元素
public static int[] partition(int[] arr, int L, int R){}
```
  - [数组中的第K个最大元素(215) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FindKthLargest.java)
- [堆排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/HeapSort.java)
- [堆排序扩展题目:已知一个基本有序的数组，基本有序是指如果把数组排好序，每个元素移动的距离不超过K，并且K相对于数组长度来说比较小，请选择合适的算法针对这个数据进行排序]()
- [排序算法的总结](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/sort/sort.md)

### 数组
- [合并区间(56) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Merge.java)
```java
  Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
```
- [最大数(179) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/LargestNumber.java)
```java
  /**
   * Comparator接收返回值为正数，就会交换a和b
   * a = 3 b = 30 (303 compareTo 330 = -1) 那就是a和b不需要交换顺序，也是我们需要的结果
   */
  Arrays.sort(numsToWord, (a, b) -> (b + a).compareTo(a + b));
```
- [缺失的第一个正数(41) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FirstMissingPositive.java)
- [分割数组(915) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/PartitionDisjoint.java)
```java
// 通过记录遍历过程中到当前位置的最大元素curMax，更新分界线的位置
int leftMax = nums[0];// left分界线左边的最大元素
int leftPos = 0;// left分界线
int curMax = nums[0];// 当前最大元素，会随着遍历不断更新，而leftMax在到了划分边界后，就固定下来了
```
- [字母排序 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/CharacterSort.java)
```java
int[] charArr = new int[52];// 偶数位置存放小写字母，奇数位置存储大写字母 aAbBcC...
// 小写字母的编码int值要比大写字母大，可以通过这个判断每个字母在数组中的存放位置
```

#### 双指针
- [有序数组的平方(977) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SortedSquares.java)
```java
// 通过记录负数区与非负数区的边界，再通过双指针合并
int neg = -1;// 区分负数与非负数,[0,neg]都为负数,[neg+1,n-1]为正数
```
- [轮转数组(189) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Rotate.java)
```java
/**
 * nums = {1，2，3，4，5，6，7} k = 2
 * 最终结果为：6，7，1，2，3，4，5
 */
k = k % length; // 数组length = 5 k = 7 实际上含义是k = 2
reverseArray(nums, 0, length - 1);
reverseArray(nums, 0, k - 1);
reverseArray(nums, k, length - 1);
```
- [移动零(283) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/MoveZeroes.java)
- [两数之和II-输入有序数组(167) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/TwoSum.java)
- [三数之和(15) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/ThreeSum.java)
```java
// 先排序，然后两层循环，利用排序后数据的性质加速查找
```
- [最接近的三数之和(16) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/ThreeSumClosest.java)
```java
/**
 * 解题关键点：使用绝对值变量
 */
private int best = 1000 * 1000;// 存储的是三数之和
public int threeSumClosest(int[] nums, int target) {
    // 利用绝对值的差值来更新答案 sum：三数之和
    if(Math.abs(sum - target) < Math.abs(best - target)){
        best = sum;    
    }    
}
```
- [四数之和(18) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FourSum.java)
- [删除有序数组中的重复项 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/RemoveDuplicates.java)
- [比较版本号(165) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/CompareVersion.java)
- [盛最多水的容器(11)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/MaxArea.java)
- [荷兰国旗问题/颜色分类(75) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/DutchFlag.java)
- [两个数组的交集II(350) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Intersect.java)
- [下一个排列(31) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/NextPermutation.java)
```java
/**
 * 核心思路：
 * 1、我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
 * 2、同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
 */
```
- [下一个更大元素III(556) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/NextGreaterElement.java)
- [最长回文子串(5) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/LongestPalindrome.java)
- [验证回文字符串Ⅱ(680) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/ValidPalindrome.java)
- [旋转链表(61) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/RotateRight.java)

#### 前缀和
- [连续数组(525) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/prefixsum/FindMaxLength.java)
- [和为K的子数组(560) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/prefixsum/SubarraySum.java)

#### 二分查找
- [二分查找 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Search.java)
- [第一个错误的版本(278) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FirstBadVersion.java)
- [搜索插入位置(35) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SearchInsert.java)
- [搜索旋转排序数组(33) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Search.java)
- [在排序数组中查找元素的第一个和最后一个位置(34) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SearchRange.java)
- [寻找旋转排序数组中的最小值(153) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FindMin.java)
- [寻找峰值(162) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FindPeakElement.java)
- [~~寻找重复数(287)~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FindDuplicate.java)
- [爱吃香蕉的珂珂(875) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/MinEatingSpeed.java)


#### 矩阵
- [螺旋矩阵(54) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SpiralOrder.java)
- [螺旋矩阵II(59) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/GenerateMatrix.java)
- [旋转图像(48) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/RotateMatrix.java)
- [搜索二维矩阵(74) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SearchInDoubleArray.java)

### 链表
- [删除链表倒数第N个节点(19) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/RemoveNthFromEnd.java)
- [合并两个有序链表(21) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/MergeTwoLists.java)
- [环形链表(141) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/HasCycle.java)
- [环形链表II(142) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/DetectCycle.java)
- [判断链表是否为回文结构 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/IsPalindrome.java)
- [将单向链表按某值划分为左边小，中间相等，右边大的形式 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SmallEqualBigger.java)
- [~给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的第一个节点，如果不相交，返回null~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/FindFirstIntersectNode.java)
- [链表的中间结点(876) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/MiddleNode.java)
- [反转链表(206) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/ReverseList.java)
- [反转链表II(92)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/ReverseBetween.java)
- [删除排序链表中的重复元素II(82) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/DeleteDuplicates.java)
- [重排链表(143) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/ReorderList.java)
- [K个一组翻转链表(25) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/ReverseKGroup.java)
```java
/**
 * 解题思路：
 * 将整个链表划分为：已翻转部分+待翻转部分+未翻转部分
 * 定义变量：
 * pre：待翻转链表的前驱
 * end：待翻转链表的末尾
 * 间接得出：
 * start: pre.next 翻转部分的头指针
 * next：end.next 待翻转部分的头指针
 */
while(end != null){
    // code    
}
```
- [LRU缓存(146) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/LRUCache.java)
```java
/**
 * 解题核心：
 * Map + 自定义的双向链表
 * private HashMap<Integer, DLinkedNode> cache;
 * 
 * 定义两个虚拟节点
 * private DLinkedNode head;// 定义虚拟头节点
 * private DLinkedNode tail;// 定义虚拟尾节点
 * 
 * 定义两个函数
 * private void removeNode(DLinkedNode node) {}
 * private void addToHead(DLinkedNode node) {}
 */
private void addToHead(DLinkedNode node) {
    // 在连接的时候要考虑当前节点、前面节点、后面节点的连接关系(双向连接)
    // 存储头节点的下一个节点，因为后续会调整head的next指针，因此先存储下来，防止替换
    DLinkedNode tmpNode = head.next;
    // 连接head 与 node节点
    head.next = node;
    node.prev = head;

    // 连接node节点与旧的队列头部实际节点
    node.next = tmpNode;
    tmpNode.prev = node;
}
```
- [两两交换链表中的节点(24) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SwapPairs.java)
- [~~排序链表(148)~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SortList.java)
- [合并K个升序链表(23) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/MergeKLists.java)
- [复制带随机指针的链表(138) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/CopyRandomList.java)
- [排序奇升偶降链表 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SortingAscendingDescendingList.java)
- [奇偶链表(328) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/OddEvenList.java)
- [相交链表(160) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/GetIntersectionNode.java)
- [两数相加(2)&两数相加II(445) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/AddTwoNumbers.java)

### 字符串
- [反转字符串(301) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/ReverseString.java)
- [最后一个单词的长度(58) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/LengthOfLastWord.java)
- [颠倒字符串中的单词(151) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/ReverseWords.java)
- [~~实现Sunday匹配(151)~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/StrStr.java)
- [~~KMP算法~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/KMP.java)
- [字符串转换整数(atoi)(8) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/MyAtoi.java)
```java
char[] charArray = str.toCharArray();
// 定义index 记录当前处理到了字符数组的哪一个位置
int index = 0;
// 1、去除前导空格
// 2、如果已经遍历完成（针对极端用例 "      "） 直接return
// 3、如果出现符号字符，仅第 1 个有效，并记录正负
// 4、将后续出现的数字字符进行转换
```
- [字符串相加(415) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/AddStrings.java)
- [36进制加法 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/Add36Strings.java)
```java
/**
 * 核心思路：
 * 将36进制转化为10进制参与运算，运算结果再转换为16进制
 * 
 * 又因为int 与 char的对应关系如下：
 * 48 ～ 57 对应 0 ～ 9
 * 97 ～ 122 对应 a ～ z
 * 
 * 因此需要定义函数进行转换
 */
// 将十进制整数转化为 36进制字符
public char getChar(int n) {
    if (n <= 9) {
        return (char) (n + '0');
    } else {
        return (char) (n - 10 + 'a');
    }
}

// 将36进制字符转化为10进制整数
public int getInt(char c) {
    if (c <= '9') {
        return c - '0';
    } else {
        return c - 'a' + 10;
    }
}

```
- [阿拉伯数字转化为中文读法 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/NumToChinese.java)
- [字符串相乘(43) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/Multiply.java)
- [~~最长公共前缀(14) ✓~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/LongestCommonPrefix.java)

### 树
> [二叉排序树/AVL树/红黑树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/%E4%BA%8C%E5%8F%89%E6%9F%A5%E6%89%BE%E6%A0%91%26%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91%26%E7%BA%A2%E9%BB%91%E6%A0%91%26B-%E6%A0%91%26B%2B%E6%A0%91%E6%80%A7%E8%83%BD%E5%AF%B9%E6%AF%94.md)

- [用递归和非递归两种方式实现二叉树的前序遍历、中序遍历、后序遍历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Traversal.java)
- [判断一颗二叉树是否为完全二叉树 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsCompleteBinaryTree.java)
- [二叉树的最近公共祖先(236) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/LowestCommonAncestor.java)
```java
private static TreeNode ans;
// 定义 dfs函数 表示 root 节点的子树中是否包含 p 节点或 q 节点，如果包含为 true，否则为 false
private static boolean dfs(TreeNode root, TreeNode p, TreeNode q){}
```
- [~~在二叉树中找到一个节点的后继节点~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/GetSuccessorNode.java)
- [二叉树的序列化与反序列化](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/SerializationAndDeserializationTree.java)
- [~~折纸问题~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/PaperFolding.java)
- [完全二叉树的节点个数](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/CountNodes.java)
- [反转二叉树 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/InvertTree.java)
- [~~对称二叉树(101) ✓~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsSymmetric.java)
- [~~Morris遍历~~](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Morris.java)
- [合并二叉树(617) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/MergeTrees.java)
- [填充每个节点的下一个右侧节点指针(116)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Connect.java)
- [二叉树展开为链表(114)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Flatten.java)
- [从前序与中序遍历序列构造二叉树(105) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/BuildTree.java)
- [树的子结构(剑指Offer26) OR 另一棵树的子树(572) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsSubStructure.java)
- [查找二叉树中给定节点对之间的距离](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/FindDistance.java)

#### 二叉搜索树(BST)
- [BST与其验证 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsValidBST.java)
- [BST的查找 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/SearchBSF.java)
- [二叉搜索树的第k大节点(54) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/KthLargest.java)
- [二叉搜索树中第K小的元素(230) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/KthSmallest.java)
- [二叉搜索树与双向链表(剑指Offer36)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/TreeToDoublyList.java)
- [删除二叉搜索树中的节点(450)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/DeleteNode.java)

#### DFS-深度优先搜索
- [最大深度与DFS ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/MaxDepth.java)
- [海岛个数问题 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/CountIslands.java)
- [统计封闭岛屿的数目(1254) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/ClosedIsland.java)
- [岛屿的最大面积(695) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/MaxAreaOfIsland.java)
- [被围绕的区域(130) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/Solve.java)
- [求根节点到叶节点数字之和(129) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/SumNumbers.java)
- [平衡二叉树(110) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/IsBalanced.java)
- [二叉树中的最大路径和(124) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/MaxPathSum.java)
- [判断一颗二叉树是否为满二叉树 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/IsFullBinaryTree.java)
- [二叉树的直径(543) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/DiameterOfBinaryTree.java)
- [相同的树(100) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/IsSameTree.java)
- [二叉树的所有路径(257) tag:回溯 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/BinaryTreePaths.java)
- [二叉树中所有距离为K的结点(863)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/DistanceK.java)
- [路径总和II(113) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dfs/PathSum.java)

#### BFS-广度优先搜索
- [腐烂的橘子(994) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bfs/OrangesRotting.java)
- [二叉树的层序遍历与BFS(102) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bfs/LevelOrder.java)
- [N叉树的层序遍历(429) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bfs/NTreeLevelOrder.java)
- [路径总和(112) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bfs/HasPathSum.java)
- [二叉树的锯齿形层序遍历(103) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bfs/ZigzagLevelOrder.java)
- [二叉树最大宽度(662) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bfs/WidthOfBinaryTree.java)

#### 堆/大根堆/小根堆
- [前K个高频单词(692) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/TopKFrequent.java)

#### 字典树
- [字典树/前缀树(208) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/trie/Trie.java)

#### 线段树
- [我的日程安排表I(729)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/segment/tree/MyCalendar.java)

### 栈
- [在不使用额外数据结构的情况下逆序栈](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/ReverseStack.java)
- [用栈实现队列(232) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/queue/MyQueue.java)
- [最小栈(155) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/MinStack.java)
- [双栈排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/StackSort.java)
- [最长有效括号(32) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/LongestValidParentheses.java)
- [基本计算器II(227)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/Calculate.java)
- [删除字符串中的所有相邻重复项(1047) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/RemoveDuplicates.java)
- [字符串解码(394)-tag:栈 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/DecodeString.java)
- [有效的括号(20) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/IsValid.java)
- [有效的括号字符串(678)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/CheckValidString.java)

#### 队列
- [设计循环队列(622)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/queue/MyCircularQueue.java)

#### 单调栈
- [单调栈](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/%E5%8D%95%E8%B0%83%E6%A0%88.md)
- [在数组中想找到一个数，左边和右边比这个数大、且离这个数最近的位置](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetNearMore.java)
- [每日温度(739) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/DailyTemperatures.java)
- [去除重复字母(316)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/RemoveDuplicateLetters.java)

### 跳表
- [跳表](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SkipList.md)

### Hash
- [数组中重复的数据(442) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/hash/FindDuplicates.java)

### 图
- [图的宽度优先遍历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/BFS.java)
- [图的深度优先搜索](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/DFS.java)
- [拓扑排序算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/TopologySort.java)
- [Dijkstra算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/Dijkstra.java)

### 位运算
- [只出现一次的数字(136) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/SingleNumber.java)
- [位1的个数(191)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/BinaryOneCount.java)
- [给定两个有符号整数a和b，返回a和b中较大的](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/GetMax.java)
- [2的幂(231)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/PowerOfX.java)
  
### 动态规划
- [买卖股票的最佳时机 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxProfit.java)
- [爬楼梯(70) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/ClimbStairs.java)
- [最大子数组和(53) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxSubArray.java)
- [最长上升子序列(300) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/LengthOfLIS.java)
- [数字转字符串的方式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/NumToStringWays.java)
- [打家劫舍(198)&打家劫舍II(213) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/Rob.java)
- [三角形最小路径和(120) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MinimumTotal.java)
- [最长公共子序列(1143)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/LongestCommonSubsequence.java)
- [接雨水(42)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/Trap.java)
- [最长重复子数组(718)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/FindLength.java)
- [单词拆分(139)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/WordBreak.java)
- [乘积最大子数组(152)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxProduct.java)
- [最大正方形(221) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaximalSquare.java)
- [最小路径和(64) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MinPathSum.java)
- [完全平方数(279)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/NumSquares.java)
- [解码方法(91)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/NumDecodings.java)
- [整数拆分(343)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/IntegerBreak.java)
- [零钱兑换(322)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/CoinChange.java)
- [不同的二叉搜索树(96)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/NumTrees.java)
- [分割等和子集(416)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/CanPartition.java)

#### 数型DP
- [树型DP介绍及解题套路](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/%E6%A0%91%E5%9E%8BDP.md)
- [二叉树节点间的最大距离问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxDistance.java)
- [派对的最大快乐值](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxHappy.java)

### 贪心算法
- [什么是贪心算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95.md)
- [会场安排问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/BestArrange.java)
- [金条切割问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/LessMoneySplitGold.java)
- [数轴覆盖](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/CordCoverMaxPoint.java)
- [跳跃游戏(55)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/CanJump.java)
- [跳跃游戏II(45)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/Jump.java)
- [移掉K位数字(402)-tag:贪心、单调栈](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/RemoveKdigits.java)
- [无重叠区间(435)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/greedy/EraseOverlapIntervals.java)

### 并查集算法
- [并查集算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/unionfind/UnionFind.java)
- [最长连续序列(128)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/unionfind/LongestConsecutive.java)
- [省份数量(547)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/unionfind/FindCircleNum.java)

### 滑动窗口
- [滑动窗口](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3.md)
- [滑动窗口最大值(239) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/window/MaxSlidingWindow.md)
- [长度最小的子数组(209) ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/window/MinSubArrayLen.md)
- [最小覆盖子串(76)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/window/MinWindow.md)
- [最大连续1的个数III(1004)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/window/LongestOnes.md)
- [无重复字符的最长子串(3)-tag:滑动窗口 ✓](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/LengthOfLongestSubstring.java)

### 回溯&剪枝
- [组合(77)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/Combine.java)
- [全排列(46)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/Permute.java)
- [全排列II(47)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/PermuteUnique.java)
- [字母大小写全排列(784)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/LetterCasePermutation.java)
- [括号生成(22)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/GenerateParenthesis.java)
- [子集(78)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/Subsets.java)
- [组合总和(39)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/CombinationSum.java)
- [组合总和II(40)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/CombinationSum2.java)
- [复原IP地址(93)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/RestoreIpAddresses.java)
```java
static final int SEG_COUNT = 4;
List<String> ans = new ArrayList<>();
// 在回溯的时候，不需要手动对已设置位置的值清除，因为在后续的递归中会将之前设置的值覆盖掉
int[] segments = new int[SEG_COUNT];
// 表示从segStart位置开始找第segId段
public void dfs(String s, int segId, int segStart) {
    // base case 添加答案
    if (segId == SEG_COUNT){
        if(segStart==s.length()){}
    }    
    // base case 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
    // 例外情况 segStart位置的元素为0直接添加到segId段
    // 一般情况，枚举每一种可能性并递归
}
```
- [单词搜索(79)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/Exist.java)
- [电话号码的字母组合(17)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/LetterCombinations.java)
- [目标和(494)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/backtrack/FindTargetSumWays.java)

### 拓扑排序
- [课程表(207)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/CanFinish.java)

### 解题的技巧
#### 观察表法
- [买苹果问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MinBags.java)
- [牛羊吃草问题(Tag:博弈论)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/EatGrass.java)
- [观察表法的总结]()

#### 预处理法
- [方格染色](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/SquareStaining.java)
- [给定一个N*N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MaxSquare.java)

#### 模拟
- [最大交换(670)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/MaximumSwap.java)
- [对角线遍历(498)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FindDiagonalOrder.java)
- [分隔链表(86)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/Partition.java)

#### 频繁解
- [土豪打榜](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MinCostCoins.java)

### 资源限制型题目
- [大数据题目](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bigdata/%E5%A4%A7%E6%95%B0%E6%8D%AE%E9%A2%98%E7%9B%AE.md)

### 其它(8)
- [约瑟夫环](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/Cir.java)
- [N皇后(51)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/SolveNQueens.java)
- [汉诺塔问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/Hanota.java)
- [金条切割问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/LessMoneySplitGold.java)
- [rand5到rand7及扩展](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/Rand5ToRand7.java)
- [缺失的括号](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetNeed.java)
- [最大公约数和最小公倍数](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MaxDivisor.java)
- [Pow(x, n)(50)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MyPow.java)

### [master公式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/GetMax.java)
