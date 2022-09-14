# Talk Is Cheap, Show Me The Code

## Java语言部分
- [死锁发生的原因]()
- [Java的JUC框架介绍]()
- [JVM的调优策略]()
- [内存泄漏与内存溢出的区别，何时产生内存泄漏]()
- [Java的虚引用、弱引用]()
- [ExecutorCompletionService]()
- [InheritableThreadLocal]()
- [CompletableFuture](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/future/CompletableFutureApiDemo.java)
- [LockSupport](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/lock/LockSupportDemo.java)
- [wait notify](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/TestSleepAndWait.java)
- [Java中的按值传递](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/base/CallByValue.java)
- [Java的反射](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/reflect/ReflectTest.java)
- [Volatile](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/jmm/VolatileDemo.java)
- [Lambda]()
- [JDK动态代理](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/proxy)
- [Synchronized](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/sync)
- [CompletableFuture 的join和get有什么区别？]()
- [为什么任何一个对象都可以成为一个锁？]()
- [非公平锁的优点]()

## Spring框架
- [@Autowired和@Resource注解的区别](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E5%92%8C%40Resource%E6%B3%A8%E8%A7%A3%E7%9A%84%E5%8C%BA%E5%88%AB.md)
- [@Autowired的实现原理](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E7%9A%84%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)

## MySQL
- [MySQL事务隔离级别]()
- [事务的特性(ACID)]()

## 计算机网络
- [TCP三次握手和四次挥手]()

## 设计模式
- [工厂模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/factory)
- [单例模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/singleton)
- [装饰器模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/decorator)

## 系统设计方面
- [高并发下如何生成订单的唯一ID]()
- [平时的项目技术设计时主要考虑的点，如何保证技术方案的可行性和扩展性]()
- [一个2G左右的文本文件，统计其中某个单词出现的次数，JVM只要512M，给出实现思路]()
- [布隆过滤器BloomFilter](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/BloomFilterDemo.java)
- [限流算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/RateLimiterTest.java)
- [常见软件的QPS](https://github.com/suxiongwei/without-me/blob/main/doc/%E5%B8%B8%E8%A7%81%E8%BD%AF%E4%BB%B6%E7%9A%84QPS.md)
- [领域驱动设计在互联网业务开发中的实践](https://tech.meituan.com/2017/12/22/ddd-in-practice.html)
- [一般实现分布式锁都有哪些方式？使用 Redis 如何设计分布式锁？使用 zk 来设计分布式锁可以吗？这两种分布式锁的实现方式哪种效率比较高？](https://github.com/doocs/advanced-java/blob/main/docs/distributed-system/distributed-lock-redis-vs-zookeeper.md)

## 其它(工具)
- [Guava的常见用法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/GuavaTest.java)
- [SpringBoot启动时自动执行代码的几种方式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/spring/startrun/package-info.java)

## LeetCode题解
### [master公式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/GetMax.java)

### 排序
- [冒泡排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/BubbleSort.java)
- [插入排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/InsertionSort.java)
- [选择排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/SelectionSort.java)
- [归并排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/MergeSort.java)
- [快速排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/QuickSort.java)
- [堆排序](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/HeapSort.java)
- [堆排序扩展题目:已知一个基本有序的数组，基本有序是指如果把数组排好序，每个元素移动的距离不超过K，并且K相对于数组长度来说比较小，请选择合适的算法针对这个数据进行排序]()
- [排序算法的总结](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/sort/sort.md)
### 二分查找
- [二分查找](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Search.java)
- [第一个错误的版本(278)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/FirstBadVersion.java)
- [搜索插入位置(35)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SearchInsert.java)
- [搜索旋转排序数组(33)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Search.java)
### 双指针
- [有序数组的平方(977)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SortedSquares.java)
- [轮转数组(189)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Rotate.java)
- [移动零(283)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/MoveZeroes.java)
- [两数之和II-输入有序数组(167)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/TwoSum.java)
### 数组
- [最长公共前缀](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/LongestCommonPrefix.java)
- [两个数组的交集II](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/Intersect.java)
- [最小和](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SmallSum.java)
- [求最大值](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/GetMax.java)
- [删除有序数组中的重复项](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/RemoveDuplicates.java)
- [前K个高频单词(692)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/TopKFrequent.java)
- [二维数组中的查找(剑指Offer04)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/SearchInDoubleArray.java)
### 链表
- [删除链表倒数第N个节点(19)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/RemoveNthFromEnd.java)
- [合并两个有序链表(21)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/MergeTwoLists.java)
- [环形链表(141)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/HasCycle.java)
- [判断链表是否为回文结构](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/IsPalindrome.java)
- [将单向链表按某值划分为左边小，中间相等，右边大的形式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SmallEqualBigger.java)
- [复制含有随机指针节点的链表](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/CopyListWithRand.java)
- [给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的第一个节点，如果不相交，返回null](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/FindFirstIntersectNode.java)
- [链表的中间结点(876)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/MiddleNode.java)
### 二叉树
- [最大深度与DFS](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/MaxDepth.java)
- [层次遍历与BFS](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/LevelOrder.java)
- [BST与其验证](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsValidBST.java)
- [BST的查找](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/SearchBSF.java)
- [用递归和非递归两种方式实现二叉树的前序遍历、中序遍历、后序遍历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Traversal.java)
- [二叉树的层次遍历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/LevelOrder.java)
- [判断一颗二叉树是否为完全二叉树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsCompleteBinaryTree.java)
- [判断一颗二叉树是否为满二叉树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsFullBinaryTree.java)
- [给定两个二叉树的节点node1和node2，找到它们的最低公共祖先节点](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/LowestCommonAncestor.java)
- [在二叉树中找到一个节点的后继节点](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/GetSuccessorNode.java)
- [二叉树的序列化与反序列化](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/SerializationAndDeserializationTree.java)
- [折纸问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/PaperFolding.java)
- [完全二叉树的节点个数](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/CountNodes.java)
- [路径总和(112)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/HasPathSum.java)
- [反转二叉树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/InvertTree.java)
- [平衡二叉树(110)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsBalanced.java)
- [相同的树(100)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsSameTree.java)
- [对称二叉树(101)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/IsSymmetric.java)
- [二叉搜索树的第k大节点(54)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/KthLargest.java)
- [Morris遍历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Morris.java)
- [合并二叉树(617)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/MergeTrees.java)
- [填充每个节点的下一个右侧节点指针(116)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/Connect.java)
### 位运算
- [只出现一次的数字](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/SingleNumber.java)
- [二进制中1的个数](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/BinaryOneCount.java)
- [给定两个有符号整数a和b，返回a和b中较大的](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bit/GetMax.java)
### 动态规划
- [买卖股票的最佳时机](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxProfit.java)
- [爬楼梯(70)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/ClimbStairs.java)
- [最大子序和(53)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxSubArray.java)
- [最长上升子序列(300)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/LengthOfLIS.java)
- [数字转字符串的方式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/NumToStringWays.java)
#### 数型DP
- [树型DP介绍及解题套路](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/%E6%A0%91%E5%9E%8BDP.md)
- [二叉树节点间的最大距离问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxDistance.java)
- [派对的最大快乐值](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/dp/MaxHappy.java)
### 字符串
- [反转字符串(301)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/ReverseString.java)
- [最后一个单词的长度(58)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/LengthOfLastWord.java)
- [颠倒字符串中的单词(151)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/ReverseWords.java)
- [实现Sunday匹配(151)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/StrStr.java)
- [KMP算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/KMP.java)
- [无重复字符的最长子串(3)-tag:滑动窗口](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/LengthOfLongestSubstring.java)
- [字符串转换整数(atoi)(8)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/str/MyAtoi.java)
### 图
- [图的宽度优先遍历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/BFS.java)
- [图的深度优先搜索](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/DFS.java)
- [拓扑排序算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/TopologySort.java)
- [Dijkstra算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/graph/Dijkstra.java)
### 贪心算法
- [什么是贪心算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95.md)
- [会场安排问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/BestArrange.java)
- [金条切割问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/LessMoneySplitGold.java)
- [数轴覆盖](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/CordCoverMaxPoint.java)
### 栈
- [在不使用额外数据结构的情况下逆序栈](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/stack/ReverseStack.java)
### 字典树
- [字典树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/trie/TrieTree.java)
### 并查集算法
- [并查集算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/UnionFind.java)
### 单调栈
- [单调栈](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/%E5%8D%95%E8%B0%83%E6%A0%88.md)
- [在数组中想找到一个数，左边和右边比这个数大、且离这个数最近的位置](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetNearMore.java)
### 滑动窗口
- [滑动窗口](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3.md)
- [生成最大窗口数组](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetMaxWindow.md)
### 深度优先搜索
- [海岛个数问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/CountIslands.java)
- [岛屿的最大面积(695)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MaxAreaOfIsland.java)

### 资源限制型题目
- [大数据题目](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/bigdata/%E5%A4%A7%E6%95%B0%E6%8D%AE%E9%A2%98%E7%9B%AE.md)
### 有序表
- [红黑树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetMaxWindow.md)
- [AVL树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetMaxWindow.md)
- [SB树](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetMaxWindow.md)
- [跳表](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/linkedlist/SkipList.md)
### 解题的技巧
#### 观察表法
- [买苹果问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MinBags.java)
- [牛羊吃草问题(Tag:博弈论)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/EatGrass.java)
- [观察表法的总结]()
#### 预处理法
- [方格染色](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/SquareStaining.java)
- [给定一个N*N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/MaxSquare.java)

### 其它
- [荷兰国旗问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/array/DutchFlag.java)
- [约瑟夫环](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/Cir.java)
- [N皇后(51)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/SolveNQueens.java)
- [汉诺塔问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/Hanota.java)
- [金条切割问题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/LessMoneySplitGold.java)
- [rand5到rand7及扩展](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/Rand5ToRand7.java)
- [缺失的括号](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/other/GetNeed.java)


## 系统设计
- [接口鉴权](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/auth/AuthUtils.java)

## 简历
[Java开发工程师](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/%E7%AE%80%E5%8E%86.md)

## 一些面试题
#### 为什么任何一个对象都可以成为一个锁？
每个对象都有一个监视器
#### 非公平锁的优点
减少线程的切换，更能充分的利用CPU
#### B-树和B+树的区别
https://www.jianshu.com/p/ace3cd6526c4<br/>
1. B+树内节点不存储数据，所有 data 存储在叶节点导致查询时间复杂度固定为 log n。而B-树查询时间复杂度不固定，与 key 在树中的位置有关，最好为O(1)。
2. B+树叶节点两两相连可大大增加区间访问性，可使用在范围查询等，而B-树每个节点 key 和 data 在一起，则无法区间查找。
3. B+树更适合外部存储。由于内节点无 data 域，每个节点能索引的范围更大更精确

