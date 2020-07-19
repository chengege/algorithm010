# 第12课 动态规划

## 知识点

1、与递归、分治区别

​	动态规划和递归或者分治没有本质上的区别（关键看有无最优子结构）

​	共性：找到重复子问题

​	差异性：最优子结构、中途可以淘汰次优解



2、一般题型

​	求最优解、最大值等



3、**关键点（步骤）**

1. 最优子结构 opt[n] = best_of(opt[n -1],opt[n -2]..) 
2. 储存中间状态 opt[i]
3. 递推公式

## 例题题目总结

### 1、Fibonacci数列

解法：

1、递归 O(2^n) O(n)

![计算机生成了可选文字: int fib (int n) {  return n  n  fib  n  fib n ](file:///C:/Users/hasee/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png)

2、记忆化递归 O(n) O(n) 

![计算机生成了可选文字: int fib (int n  if (n <= 1)  return n;  if (memo n  memo [n  return memo  int [ ]  memo  fib  n  n  fib  n  -2); ](file:///C:/Users/hasee/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png)

3、动态规划 一维

![image-20200719170736808](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719170736808.png)

### 2、路径计数

1、分治

![image-20200719171059346](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719171059346.png)

![image-20200719171146311](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719171146311.png)

2、动态规划 二维

递推公式：

​	![](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719171325386.png)

![](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719171644795.png)

![image-20200719171635258](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719171635258.png)

### 3、最长公共子序列

关键：扩展成二维数组来定义状态

![image-20200719172423407](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719172423407.png)

子问题：

![image-20200719172632082](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719172632082.png)

![image-20200719172954739](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719172954739.png)

![image-20200719173008433](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719173008433.png)

### 4、三角形的最小路径和

![1.  2.  a.  b.  c.  brute—force,  iæy-z, left  problem(i,j)  or right:  2An  = min(sub(i+l, j), sub(i+l, ](file:///C:/Users/hasee/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png)

![image-20200719181216779](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719181216779.png)

![image-20200719181245323](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719181245323.png)

### 5、最大子序列和

![image-20200719181829572](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719181829572.png)

![image-20200719182137579](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719182137579.png)

### 6、零钱兑换

![image-20200719182418642](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719182418642.png)

![image-20200719182543969](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719182543969.png)

### 7、打家劫舍

1、升维

![image-20200719182935190](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719182935190.png)

![image-20200719182953729](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719182953729.png)

2、优化，一维

![image-20200719183043528](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719183043528.png)

![image-20200719183239002](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719183239002.png)

3、再优化，滚动数组

![image-20200719183137726](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200719183137726.png)