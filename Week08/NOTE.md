# 第16课 位运算

十进制转二进制

![Remainder  5610  100111002 ](https://github.com/chengege/algorithm010/blob/master/Week08/image/clip_image001.png)

 

移位

![含 义  运 算 符  左 移  0011 = > 0110  右 移  0110 = > 0011 ](https://github.com/chengege/algorithm010/blob/master/Week08/image/clip_image002.png)

位运算

![含 义  按 位 与  按 位 取 反  0011 = > 1 100  按 位 异 或 （ 相 同 为 零 不 同 为 一 ）  运 算 符  0011  1011  0011  1011  0011  1011  示 例  = > 1011  = > 0011  = > 1 0 ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image003.png)

 

常用操作

![x  x A Is=-x Is = —O  Is  x Ax = 0  c = a Ab  // associative ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image004.png)

 

![1 · 将 × 最 右 边 的 n 位 清 零 ： × & 00 < < n)  2 · 获 取 × 的 第 n 位 值 （ 0 或 者 1 ） ： （ × > > n) & 1  3 · 获 取 × 的 第 n 位 的 幂 值 ： × & 0 < < n)  4 · 仅 将 第 n 亻 立 置 为 1 ： × 这 1 < < n ）  5 · 仅 将 第 n 亻 立 置 为 0 ： × & （ 1 < < n ） ）  6 ， 将 × 最 高 位 至 第 n 位 （ 含 ） 清 零 ： x & （ 0 < < n) 一 1 ） ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image005.png)

实战中常用:

![· 判 断 奇 偶 :  x % 2 = = 1 一 > ( x & 1 ) = = 1  x % 2 = = 0 一 > ( x & 1 ) = = 0  · x > > 1 —>X / 2  即 : x = x / 2 ;  mid=(left +right)/2; 一 > mid=(left +right) > > 1 ;  · X = X & 1 ) 清 零 最 低 位 的 1  · X & Ⅸ = > 得 到 最 低 位 的 1 ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image006.png)

# 第17课 布隆过滤器和LRU缓存

## 布隆过滤器

一个很长的二进制向量和一系列随机映射函数。

### 作用

可以用于检索一个元素是否存在集合中。

### 使用场景

快速判断元素是否存在，即前置查询。存在->进一步查询元数据（可能误判），不存在->直接跳过。

### 优缺点

优点：空间效率和查询效率远超一般算法

缺点：有一定的误识别率和删除困难。

 

实现：

![o  ı  o  ı  ı  1  o  0  0  0  o  ı  o  I  0  o  ı  o ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image007.png)

![Bloom Filter  c  True positive  True negative  False positive ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image008.png)

### 代码模板

https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java

https://github.com/Baqend/Orestes-Bloomfilter

## LRU缓存

是一种缓存替换规则。

规则：最少最近被使用的缓存数据淘汰

查询、修改均为O(1)

JAVA中的实现类：LinkedHashMap

### 实现

hash table + double linkedList![0000*  0 ](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image009.png)

### 代码模板

见：[146]LRU缓存机制.java

# 第18课 排序算法

分类

比较类排序（非线性时间）：

- ​	通过比较来决定元素间的相对次序，**时间复杂度不能突破****O(logn)**

非比较类排序（线性时间）：

- ​	不通过比较来决定元素间的相对次序，可以突破基于比较排序的时间下限，以线性时间运行

- ​	适用整型排序，一般需要额外内存空间

![计算机生成了可选文字: 排序算法 冒泡排序 交换排序 快速排序 简单插入排序 插入排序 希尔排序 比较类排序 简单选择排序 选择排序 堆排序 二路归并排序 归并排序 多路归并排序 计数排序 桶排序 基数排序](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image010.png)

## 时间复杂度![计算机生成了可选文字: 排序方法 插入排序 希尔排序 选择排序 堆排序 冒泡排序 快速排序 归并排序 计数排序 桶排序 基数排序 时间复杂度（平均） 0佃2丿 0佃2丿 0佃/0g2用 0佃2丿 0伽/0g2 0伽/0g2 O(n+k丿 0佃+k丿 0佃閃 时间复杂度（最坏） 02丿 02丿 0佃2丿 0佃/四2门丿 0佃2丿 0伽2丿 0伽g2R1丿 0佃+k丿 02丿 0*k丿 时间复杂度（最好） 0佃丿 0佃丿 0佃2丿 0佃/og2F1丿 0佃丿 0伽g2用 0伽g2用 0佃+k丿 0佃丿 0佃*k丿 空间复杂度 00丿 0(1丿 0(1丿 0(1丿 0(1丿 0佃/0g2 0佃丿 0佃+k丿 0佃+k丿 0佃+k丿 稳定性 稳定 不稳定 不稳定 不稳定 稳定 不稳定 稳定 稳定 稳定 稳定](https://github.com/chengege/algorithm010/tree/master/Week08/image/clip_image011.png)

## 代码模板

### 插入排序

```
/**
 * 插入排序
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 *
 * O(n ^ 2)
 * O(1)
 */
public void insertionSort(int[] arr){
    for(int i = 1;i < arr.length;i++){
        int preIndex = i - 1;
        int current = arr[i];
        while(preIndex >= 0 && arr[preIndex] > current)
            arr[preIndex + 1] = arr[preIndex--];
        arr[preIndex + 1] = current;
    }
}
```

### 希尔排序

```
/**
 * 希尔排序(插入排序改进版)
 *
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * O（n^1.3）
 */
public void shellSort(int[] arr) {
    for(int gap = arr.length / 2;gap > 0;gap /= 2){ // 分组，最开始为数组一半，每次/2
        // 对各个分组进行插入排序
        for(int i = gap;i < arr.length;i++){
            // 将当前元素插入到正确位置
            int j = i;
            int current = arr[i];
            // 按组进行插入，组内元素两两相隔gap
            while(j - gap >= 0 && current < arr[j - gap]){
                arr[j] = arr[j - gap];
                j = j - gap;
            }
            arr[j] = current;
        }
    }
}
```

### 选择排序

```
/**
 * 选择排序
 * 每次循环寻找最小数，循环结束与当前位置交换
 * 每次把小的数往前面放
 *
 * O(n ^ 2)
 * O(1)
 */
public void selectionSort(int[] arr){
	for(int i = 0; i < arr.length - 1; i++) {
		int minIndex = i;
		for(int j = i + 1;j < arr.length;j++){
			if(arr[j] < arr[minIndex])
				minIndex = j;
		}

		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}
}
```

### 冒泡排序

```
/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个
 * 大的往后放
 *
 * O(n ^ 2)
 * O(1)
 */
public void bubbleSort(int[] arr){
    for(int i = 0;i < arr.length - 1;i++){
        boolean sort = false;
        for(int j = 0;j < arr.length - 1 - i;j++){
            if(arr[j] > arr[j + 1]){
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                sort = true;
            }
        }
        if(!sort) break;
    }
}
```

### 快速排序

```
/**
 * 快速排序
 * 数组取标杆pivot
 * 将小元素放pivot左边，大元素放右侧
 * 依次对右边和右边的子数组继续快排
 * O(n * log n)
 */
public void sort(int[] arr) {
    quickSort(arr,0,arr.length - 1);
}
public void quickSort(int[] arr,int begin,int end){
    if(begin >= end) return;
    int pivot = patition(arr,begin,end); // 获取pivot
    // pivot 两边递归
    quickSort(arr,begin,pivot - 1);
    quickSort(arr,pivot + 1,end);
}

private int patition(int[] arr, int begin, int end) {
    int pivot = end, // 标杆位置
            counter = begin; // 小于 pivot的个数
    for(int i = begin;i < end;i++){
        if(arr[i] < arr[pivot]){
            int temp = arr[i];
            arr[i] = arr[counter];
            arr[counter] = temp;
            counter++;
        }
    }
    int temp = arr[pivot];
    arr[pivot] = arr[counter];
    arr[counter] = temp;
    return counter;
}
```

### 归并排序

```
/**
 * 归并排序
 * 把长度为n的序列分成两个长度为n/2的子序列
 * 对这两个子序列分别采用归并排序
 * 将两个排序好的子序列合并成一个最终的序列
 *
 * O(n * log n)
 * O(n)
 */
public void sort(int[] arr) {
    mergetSort(arr,0,arr.length - 1);
}

private void mergetSort(int[] arr, int left, int right) {
    if(left >= right) return;
    int mid =  (left + right) >> 1; //  取中值

    // 左右子序列排序
    mergetSort(arr,left,mid);
    mergetSort(arr,mid + 1,right);
    // 合并两个有序数组
    merge(arr,left,mid,right);
}

private void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    // 排序
    while(i <= mid && j <= right){
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }

    // 未完成的部分继续填充入temp中
    while(i <= mid) temp[k++] = arr[i++];
    while(j <= right) temp[k++] = arr[j++];

    // 将排序好的赋值给原数组
    for(int p = 0;p < temp.length;p++){
        arr[left + p] = temp[p];
    }
    // 也可使用
    // System.arraycopy(temp,0,arr,left,temp.length);
}
```

### 堆排序

```
/**
 * 使用sdk自带 PriorityQueue
 *  1. 数组元素依次建立小顶堆
 *  2. 依次取堆顶元素，并删除
 */
public void sort(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for(int i = 0;i < arr.length;i++)
        pq.add(arr[i]);

    for(int i = 0;i < arr.length;i++)
        arr[i] = pq.poll();
}



/**
 * 手动维护堆
 * 1、将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 2、将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 3、交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public void sort(int[] arr) {
    if(arr.length <= 1) return;
    for(int i = arr.length / 2 - 1;i >= 0;i--) // 建立大顶堆
        heapify(arr,arr.length,i);

    // 最大值依次放入队尾，并对0~当前位置重新建立大顶堆
    for(int i = arr.length - 1;i >= 0;i--){
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr,i,0);
    }
}

/**
 * （1）索引为i的左孩子的索引是（2*i+1)
 * （2）索引为i的右孩子的索引是（2*i+2)
 * （3）索引为i的父节点索引是floor((i-1)/2)
 */
private void heapify(int[] arr, int length, int i) {
    int left = 2 * i + 1,right = 2 * i + 2;
    int largest = i;
    if(left < length && arr[left] > arr[largest])
        largest = left;

    if(right < length && arr[right] > arr[largest])
        largest = right;

    if(largest != i){
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr,length,largest);
    }
}
```

### 计数排序

```
/**
 * 计数排序
 * 只适用于整形，且数组不能太大
 * 统计每个数出现的次数
 * 遍历统计数组，数字的出现次数反向填充回原数组
 *
 * O(n)
 * O(n)
 */
public void countingSort(int[] arr) {
    int maxValue = Integer.MIN_VALUE;
    for (int num : arr) {
        if(num > maxValue)
            maxValue = num;
    }

    int[] temp = new int[maxValue + 1];
    for(int num : arr)
        temp[num]++;

    int index = 0;
    for(int i = 0;i < temp.length;i++){
        while(temp[i] != 0){
            arr[index++] = i;
            temp[i]--;
        }
    }
}
```

### 桶排序

```
/**
 * 桶排序
 *
 * 设置一个定量的数组当作空桶；
 * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 对每个不是空的桶进行排序；
 * 从不是空的桶里把排好序的数据拼接起来。
 *
 * O(n)
 * O(n)
 */
public void bucketSort(int[] arr) {
    int maxValue = Integer.MAX_VALUE,
            minValue = Integer.MIN_VALUE;
    for(int num:arr){
        maxValue = Math.max(maxValue,num);
        minValue = Math.min(minValue,num);
    }

    // 将数分配到各个桶中
    List<List<Integer>> buckets = new ArrayList<>();
    for(int i = 0;i < arr.length;i++){
        int index = (arr[i] - minValue) / arr.length; // 桶的数量也可自己设置  arr.length
        List<Integer> bucket = buckets.get(index);
        if(bucket == null)
            bucket = new ArrayList<>();
        bucket.add(arr[i]);
    }

    int index = 0;
    for(int i = 0;i < buckets.size();i++){
        Collections.sort(buckets.get(i));
        for(int j = 0;j < buckets.get(i).size();j++){
            arr[index++] = buckets.get(i).get(j);
        }
    }

}
```

### 基数排序

```
/**
 * 基数排序
 *
 * 取得数组中的最大数，并取得位数；
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 *
 * O(n)
 * O(n)
 */
public void radixSort(int[] arr) {
    int maxBin = maxBin(arr); // 获取最大位数
    List<List<Integer>> list = new ArrayList<>();
    for(int i  = 0; i < 10; i ++) { // 初始化数组
        list.add(new ArrayList<>());
    }
    // 按位数排序
    for(int i = 0, factor = 1; i < maxBin; factor *= 10, i ++) {
        for(int j = 0; j < arr.length; j ++) {
            list.get((arr[j]/factor)%10).add(arr[j]); // 按位数存入数组
        }
        int index = 0;
        for(int j = 0; j < list.size(); j ++) {
            while(!list.get(j).isEmpty()) {
                arr[index++] = list.get(j).remove(0);
            }
        }
    }
}
public int maxBin(int[] arr) {
    int maxLen = 0;
    for(int i = 0; i < arr.length; i ++) {
        int size = Integer.toString(arr[i]).length();
        maxLen =  size > maxLen ? size : maxLen;
    }
    return maxLen;
}
```
