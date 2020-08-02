//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 134 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 位运算 + dfs
     * O(n!)
     * O(1);
     */
    int count;
    public int totalNQueens(int n) {
        count = 0;
        solve(0,0,0);
        return count;
    }
    public void solve(n,int n ,int row,int pie,int na){
        if(row == ((1 << n) - 1)){ //全部填满(全为1)
            count++;
            return;
        }
        // 得到当前行安全位置
        // (1 << n) - 1) n个1
        // (~(row | pie | na)) 计算安全位置
        int pos = ((1 << n) - 1) & (~(row | pie | na));//
        while(pos != 0){
            int p = pos & (-pos); // 取最低位1
            pos &= (pos - 1); // 清除p位置，即清除最后一个1位置 同 pos -= p;
            // row | p 占据当前位置
            // (pie | p) << 1 撇 下一行需要左移一位 捺同
            solve(row | p,(pie | p) << 1,(na | p) >> 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
