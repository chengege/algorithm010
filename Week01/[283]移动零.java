//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


/**
 * 思路：
 * 1、new新数组，非0放前面，0放后面。     不符合题目在原数组操作
 * 2、双重遍历，0与下一个非0交换
 *
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1、双重遍历，0与下一个非0交换
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */
    public void moveZeroes(int[] nums) {
        for(int i = 0;i < nums.length - 1;i++){
            boolean hasZero = false;// 后面元素是否还存在非0
            if(nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {//取当前下一位
                    if(nums[j] != 0){
                        // 交换位置
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    if(j == nums.length -1){
                        hasZero = true;
                    }
                }
            }
            if(hasZero){
                break;
            }
        }
    }

    /**
     * 2、两个指针，一个记录0元素下标，遇到非0交换
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;// 0元素下标
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                if(i != j){ // 非当前0位置
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
