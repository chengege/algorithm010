//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 回溯，尝试每种走法
     * O(n^k)
     * O(1)
     */
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        return canJump(0,nums);
    }
    public boolean canJump(int index,int[] nums){
        if(index == nums.length - 1) return false;
        int num = nums[index];

        if(num + index >= nums.length - 1) return true;

        for(int i = 1;i <= num;i++){
            if(canJump(index + i,nums)) return true;
        }
        return false;
    }

    /**
     * 数组，能到达的节点做标记
     * O(n^2)
     * O(n)
     */
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used,false);
        used[0] = true;
        for(int i = 0;i < nums.length - 1;i++){
            if(used[i]){ // 可以走到当前位置
                for(int j = 1;j <= nums[i];j++){
                    used[j + i] = true;
                    if(j + i >= nums.length - 1) return  true; // 可以走到最后
                }
            }
        }
        return false;
    }

    /**
     * 贪心
     * O(n)
     * O(1)
     */
    public boolean canJump(int[] nums) {
        if(nums == null) return false;
        int endReachable = nums.length - 1;
        for(int i = endReachable;i >= 0;i--){
            if(nums[i] + i >= endReachable)
                endReachable = i;
        }
        return endReachable == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
