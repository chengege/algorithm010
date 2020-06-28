//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 递归
     *
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k== 0) return res;
        combine(1,n,k,new LinkedList<Integer>(),res);
        return res;
    }
    private void combine(int first,int n,int k,LinkedList<Integer> list,List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = first;i <= n;i++){
            list.add(i);
            combine(i + 1,n,k,list,res);
            list.removeLast();
        }
    }

    /**
     * 字典序
     * 将 nums 初始化为从 1 到 k的整数序列。 将 n + 1添加为末尾元素，起到“哨兵”的作用。
     * 将指针设为列表的开头 j = 0.
     *
     * While j < k :
     *
     * 将nums 中的前k个元素添加到输出中，换而言之，除了“哨兵”之外的全部元素。
     *
     * 找到nums中的第一个满足 nums[j] + 1 != nums[j + 1]的元素，并将其加一
     * nums[j]++ 以转到下一个组合。
     *
     */
    public List<List<Integer>> combine(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
            nums.add(i);
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                nums.set(j, j++ + 1);
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
