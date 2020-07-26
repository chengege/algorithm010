# 第13课 字典树和并查集

## 字典树

字典树（trie树），又称单词查找树或键树，是一种树形结构。

### 应用场景

统计和排序大量字符串。经常被用于搜索引擎用于文本词频统计。

### 优点

最大限度减少无谓的字符串比较，查询效率比hash表高	

### 基本性质

1. 节点本身不存完整单词
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
3. 每个节点的所有子节点路径代表的字符都不相同

### 结构

![image-20200726212314003](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726212314003.png)

### 内部实现

![image-20200726212333284](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726212333284.png)

核心思想：

- 空间换时间
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率目的。

### 代码模板

```
class Trie {
    private class Node{
        private Node[] nodes;
        private boolean isEnd;

        public Node(){
            nodes = new Node[26];
            isEnd = false;
        }

        public Node getNode(char c){
            return nodes[c - 'a'];
        }

        public Node getAndSet(char c){
            if(nodes[c - 'a'] == null){
                nodes[c - 'a'] = new Node();
            }
            return nodes[c - 'a'];
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            node = node.getAndSet(c);
        }
        node.setEnd();
    }

    private Node searchPre(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            node = node.getNode(c);
            if(node == null) break;
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchPre(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPre(prefix) != null;
    }
}
```

## 并查集

### 适用场景

- 组团
- 配对

如 微信好友、群组

### 基本步骤

1、makeSet(x)：建立新的并查集，其中包含s个单元素集合。

2、unionSet(x,y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。

3、find(x)：找到元素x所在的集合的代表，该操作也可用于判断两个元素是否位于同一集合，只要将它们各自的代表比较一下就行了。



###  代码模板

![image-20200726212542921](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726212542921.png)



# 第14课 高级搜索

### 双向BFS搜索

### 搜索步骤

![image-20200726212714049](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726212714049.png)

### 代码模板

```
public void bothwayBfs(T beginNode,T endNode){
    // 1、定义两个Set分别记录从前、后遍历节点，并将头尾节点加入对应set
    Set<T> beginSet = new HashSet<>();
    Set<T> endSet = new HashSet<>();
    beginSet.add(beginNode);
    endSet.add(endNode);

    // 2、按需，记录访问节点
    Set<T> visited = new HashSet<>();


    while(!beginSet.isEmpty() && !endSet.isEmpty()){
        // 3、遍历两个set中节点较少的
        if(beginSet.size() > endSet.size()){
            Set<T> temp = beginSet;
            beginSet = endSet;
            endSet = temp;
        }

        Set<T> temp = new HashSet<>();
        for(T node : beginNode){

            // 4、终止条件 前后遍历相交
            if(endSet.contains(node)) return;

            // 5、加入未遍历节点
            if(!visited.contains(node))
                temp.add(node);
        }
        beginSet = temp;
    }
}
```

## 启发式搜索（A*）

本质：优先搜索优先级高的

### 代码模板

基于BFS

使用优先队列

![image-20200726212850226](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726212850226.png)

### 估价函数

用来评价哪些节点最有希望的是一个我们要找的节点，是一种告知搜索方向的方法。



二维矩阵最短路径：

1、欧拉距离：![image-20200726213057633](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726213057633.png)

2、曼哈顿距离（更优）

![image-20200726213110797](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726213110797.png)

# 第14课 红黑树和AVL树

## AVL树

严格平衡

### 平衡因子

左子树的高度减去右子树的高度（有时相反）

![image-20200726224124898](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726224124898.png)



### 旋转操作

1、右右子树-左旋

2、左左子树-右旋

3、左右子树-左右旋

4、右左子树-右左旋

![image-20200726223841615](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726223841615.png)

 

### 缺点

1、节点需要存储额外信息

2、调整次数频繁

## 红黑树

近似平衡二叉树，确保任何一个节点的左右子树的**高度差小于2倍**

 

### 特性

- 每个节点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶节点是黑色，且是空节点
- 不能有相邻的两个红色节点
- 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点

![image-20200726223958058](C:\Users\hasee\AppData\Roaming\Typora\typora-user-images\image-20200726223958058.png)