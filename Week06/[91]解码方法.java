//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 递归
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 1;i < s.length();i++){
            int first = Integer.valueOf(s.substring(i, i+1)); // 当前数字
            int second = Integer.valueOf(s.substring(i-1, i+1));// 前一位+当前
            if(first >= 1 && first <= 9) {
                dp[i] = dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += i >=2 ? dp[i-2] : 1;
            }
        }
        return dp[s.length() - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
