//我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划
     * O(n)
     * O(n)
     */
    public int nthUglyNumber(int n) {
        int p2 = 0,p3 = 0,p5 = 0;// a b c分别指向 2 3 5 的结果
        int[] res = new int[n];
        res[0] = 1;// 首个数字为1
        for(int i = 1;i < n;i++){
            int r2 = res[a] * 2,r3 = res[b] * 3,r5 = res[c] * 5;
            res[i] = Math.min(Math.min(n2,n3),n5); //取三个数中最小值
            // 当前数，指针向后移一位
            if(res[i] == r2) a++;
            if(res[i] == r3) b++;
            if(res[i] == r5) c++;
        }
        return res[n -1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
