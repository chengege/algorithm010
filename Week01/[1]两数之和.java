//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

/**
 * 1、双重遍历
 * 2、哈希表
 */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1、双重遍历
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length - 1;++i){
            for(int j = i + 1;j < nums.length;++j){//同一个元素不能使用两遍
                if(target == nums[i] + nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 2、哈希表
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> temp = new HashMap<>();
        for(int i = 0;i < nums.length;++i){
            int diff = target - nums[i];
            if(temp.get(diff) != null){
                return new int[]{temp.get(diff),i};
            }
            temp.put(nums[i],i);
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
