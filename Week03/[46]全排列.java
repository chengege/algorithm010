//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 递归回溯
     * O(n!)
     * O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums,res,new ArrayList<>());
        return res;
    }
    public void permute(int[] nums, List<List<Integer>> res,List<Integer> list) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int num:nums){
            if(!list.contains(num)){
                list.add(num);
                permute(nums,res,list);
                list.remove(list.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
