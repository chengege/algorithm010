

# 第9课 深度优先搜索和广度优先搜索

## 深度优先搜索

### 1、遍历顺序

树：

![image-20200705180905084](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200705180905084.png)

图：

![image-20200705165921332](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200705165921332.png)

### 2、代码模板

递归写法：

``` pyt
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```

非递归写法（栈模拟）：

``` py
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
	while stack: 
		node = stack.pop() 
		visited.add(node)
		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 
	# other processing work 
	...
```

## 广度优先搜索

### 1、遍历顺序

![image-20200705170505425](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200705170505425.png)

### 2、代码模板

```py
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```

# 第10课 贪心的实现、特性及实战题目解析

一种在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法。

## 与回溯、动态规划差异

贪心：当下做局部最优判断，不能回退

回溯：能够回退

动态规划：保存之前结果，最优判断+回退

## 特点

- 全局不一定是最优
- 一旦可以用贪心算法解决，一定是最优解
- 高效且接近最优解

## 使用场景

- 解决一些最优化问题。如求图中最小生成树、求哈夫曼编码
- 用作辅助算法或者直接解决一些要求结果不特别精确的问题。
- 问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。

# 第11课 二分查找的实现、特性及实战题目解析

## 前提条件

1、目标函数单调性（有序）

2、存在上下界

3、能够通过索引访问

## 代码模板

```py
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

# 本周学习总结

1、对于本周学习的知识点应用，贪心算法相对来说比较不熟练，很难想到要使用贪心。

2、本周对于之前刷过的题目重刷，有些题目忘记之前的解法，有些慢慢回忆能够回忆起来，总体来说还不够熟练，后续还需加强。

3、坚持！坚持！！坚持！！！



