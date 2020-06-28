//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

// 存下标

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1、递归，结果存下标，返回时取数值
     *      * O(N×N!)
     *      * O(N×N!)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        permuteUnique(nums,res,new ArrayList<Integer>());
        return new ArrayList<>(res);
    }
    private void permuteUnique(int[] nums,Set<List<Integer>> res,List<Integer> list){
        if(list.size() == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(Integer i:list){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!list.contains(i)){
                list.add(i);
                permuteUnique(nums,res,list);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 1优化，提前剪枝
     * O(N×N!)
     * O(N×N!)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序，方便后续剪枝判断
        permuteUnique(nums,res,new ArrayList<Integer>());
        return res;
    }
    private void permuteUnique(int[] nums,List<List<Integer>> res,List<Integer> list){
        if(list.size() == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(Integer i:list){
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(list.contains(i)) continue;

            if(i > 0 && nums[i] == nums[i - 1] && list.contains(i - 1)) continue;// 剪枝条件

            list.add(i);
            permuteUnique(nums,res,list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 使用数组记录是否使用
     * O(N×N!)
     * O(N×N!)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums,used,res,new ArrayList<>());
        return res;
    }
    private void permuteUnique(int[] nums,boolean[] used,List<List<Integer>> res,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            permuteUnique(nums,used,res,list);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
