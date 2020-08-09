//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2533 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int lo = 0,// 起始位置
            maxLen = 0;// 长度
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;

        for(int i = 0;i < len - 1;i++){
            extendPalindrome(s,i,i); // 奇数位
            extendPalindrome(s,i,i + 1); // 偶数位
        }
        return s.substring(lo,lo+maxLen);
    }
    public void extendPalindrome(String s,int j,int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            // 向两边扩张
            j--;
            k++;
        }

        if(maxLen < k - j - 1){
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    /**
     * dp  i：起点 j：终点
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1;i >= 0;i--){
            for(int j = i;j < n;j++){

                // 1、i == j
                // j - i < 2 ： 长度大于2
                // dp[i + 1][j - 1] 子串是回文串
                dp[i][j] = s.charAt(i) == s.charAt(j) &&
                        (j - i < 2 || dp[i + 1][j - 1]);

                if(dp[i][j] && j - i + 1 > res.length())
                    res = s.substring(i,j + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
