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

![dp顺推模板](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image001.png)

## 高级动态规划

1、状态拥有更多维度

2、状态方程更加复杂

## 动态规划习题总结

[总结](https://github.com/chengege/algorithm010/tree/master/Week09/动态规划.one) 

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

![遍历字符串](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image002.png)

 

### 字符串比较

![字符串比较](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image003.png)

### 字符串匹配算法

1、暴力法（brute force）

O(M * N)

![代码模板 ](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image004.png)

2、Rabin-Karp算法

对暴力优化：通过子串hash值比较是否相等

平均O(n)，最坏O(m ^ 2)

![算法思想](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image005.png)

 

![代码模板](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image006.png)

3、KMP算法

![算法思想](https://github.com/chengege/algorithm010/tree/master/Week09/image/clip_image007.png)

https://www.bilibili.com/video/av11866460?from=search&seid=17425875345653862171

[http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html](http://www.ruanyifeng.com/blog/2013/05/Knuth–Morris–Pratt_algorithm.html)

4、Boyer-Moore算法 

https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html

5、Sunday算法

https://blog.csdn.net/u012505432/article/details/52210975、

