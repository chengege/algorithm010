# 第19课 高级动态规划

## 初级动态规划总结

动态规划和递归或者分治没有本质上的区别（关键看有无最优子结构）

共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

 

一般题型：求最优解、最大值等

### 关键点（步骤）

1. 最优子结构 opt[n] = best_of(opt[n -1],opt[n -2]..) 
2. 储存中间状态 opt[i]
3. 递推公式

### dp顺推模板

![function DP():  fori=O..M{  forj=0..N{  dp[i][j] =  return dp[M][N]; ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image001.png)

## 高级动态规划

1、状态拥有更多维度

2、状态方程更加复杂

## 动态规划习题总结

[动态规划习题总结]: https://github.com/chengege/algorithm010/tree/master/Week09/动态规划.one



## 作业

在学习总结中，写出[不同路径 2 ](https://leetcode-cn.com/problems/unique-paths-ii/)这道题目的状态转移方程。

```java
if(a[i][j] == '空地')
	dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
else
	dp[i][j] = 0
```

# 第20课 字符串算法

## 特性

java、js、C#、Python、Go中String是不可变的，改变字符串相当于是新创建一个String。

## 常见操作

### 遍历字符串

![• Python:  for ch in "abbc" :  print(ch)  • Java:  "abbc" ,  String x =  for (int i = O; i < x.size(); ++i) {  char ch = x.charAt(i);  for ch in x.toCharArray() {  System.out.println(ch);  string x( "abbc" );  for (int i = O; i < sl .length(); i++) {  cout << x[i]; ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image002.png)

 

### 字符串比较

![Java:  String  String  x = new String("abb");  new ;  —-> false  x. equals (y)  —-> true  x. equalsIgnoreCase(y)  —-> true ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image003.png)

### 字符串匹配算法

1、暴力法（brute force）

O(M * N)

![public static int forceSearch( String  int M = txt. length( ) ;  int N = pat. length();  for (int i  int j;  for (j —  String pat)  if  (txt. charAt(i + j)  break;  = pat.charAt(j))  if  return  return i;  -1; ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image004.png)

2、Rabin-Karp算法

对暴力优化：通过子串hash值比较是否相等

平均O(n)，最坏O(m ^ 2)

![Rabin-Karpn 法 的 田 怍·  1 · 假 设 子 串 的 长 度 为 M (pat), 目 标 字 符 串 的 长 度 为 N (txt)  2 · 计 算 子 串 的 hash 值 hash_pat  3 · 计 算 目 标 字 符 串 t × t 中 每 个 长 度 为 M 的 子 串 的 hash 值 （ 共 需 要 计 算 N-M+I 次 ）  4 · 比 较 hash 值 ： 如 果 hash 值 不 同 ， 字 符 串 必 然 不 匹 配 ； 如 果 hash 值 相 同 ， 还  需 要 使 用 朴 素 算 法 再 次 判 断 ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image005.png)

 

![public final static int D = 256;  public final static int Q = 9997;  static int RabinKarpSerach(String txt, String pat) {  int M = pat.length();  int N = txt.length();  int i, j'  int patHash = O, txtHash O;  for (i = O; i < M; i++  patHash = (D * patHash + pat.charAt(i)) % Q  txtHash = (D * txtHash + txt.charAt(i)) % Q  int highestPow  1; // pow(256, M-1)  highestPow -  highestPow * D) % Q  for (i = O; i  if (patHash txtHash) {  for (j = O; j < M, j+  if (txt charAt(i + j)  pat.charAt(j))  break;  if (j M  return i;  if (i < N -M) {  txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q  if (txtHash < O)  txtHash +2 Q  return -1; ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image006.png)

3、KMP算法

![KMP 算 法 (Knuth-Morris-Pratt) 的 思 想 就 是 ， 当 子 串 与 目 标 字 符 串 不  匹 配 时 ， 其 实 你 已 经 知 道 了 前 面 已 经 匹 配 成 功 那 一 部 分 的 字 符 （ 包 括 子  串 与 目 标 字 符 串 ） 。 以 阮 一 峰 的 文 章 为 例 ， 当 空 格 与 D 不 匹 配 时 ， 你 其  实 知 道 前 面 六 个 字 符 是 "ABCDAB" 。 KMP 算 法 的 想 法 是 ， 设 法 利 用  个 已 知 信 息 ， 不 要 把 " 搜 索 位 置 " 移 回 已 经 比 较 过 的 位 置 ， 继 续 把 它 向  后 移 ， 这 样 就 提 高 了 效 率 。 ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image007.png)

https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171

[http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html](http://www.ruanyifeng.com/blog/2013/05/Knuth–Morris–Pratt_algorithm.html)

4、Boyer-Moore算法 

https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html

5、Sunday算法

https://blog.csdn.net/u012505432/article/details/52210975、

