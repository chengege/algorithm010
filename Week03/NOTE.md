# 第7课 泛型递归、树的递归

本质：通过函数体进行循环

## 特点

- 向下进入不同层，向上又回到原来一层
- 通过参数等回到上一层
- 每一层都是一份拷贝

## 模板

``` java
public void recur(int level, int param) {
    // terminator 递归终结条件
    if (level > MAX_LEVEL) {  
        // process result 
        return;
    }
    // process current logic 处理当前层
    process(level, param);
    // drill down 下探到下一层
    recur( level: level + 1, newParam);
    // restore current status 清理当前层

}
```

## 思维要点

1、不要人肉进行递归（画递归树等）

2、找到最近最简方法，将其拆解成可重复解决问题（重复子问题）

3、数学归纳法思维

# 第8课 分治、回溯

## 分治

本质上是一种递归，在递归状态树，对一个问题要化解成好几个子问题。

### 代码模板

与递归类似，第四步前需要汇总结果

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  # process and generate the final result 汇总结果
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

## 回溯

采用试错，答案一个个试

通常采用递归方式实现

# 本周学习心得

1、情况继续改善，刷题时能结合所学知识想解法，不足之处是有时候虽然能想到某种方法可以解，但是有些具体步骤、关键判断会遗漏或者想得不够清晰。

2、思维方式还没养成习惯，有时候会情不自禁就进行人肉递归。

3、薄弱点依然是时间复杂度和空间复杂度的计算，特别本周基本都是递归算法。

4、坚持！坚持！！坚持！！！

