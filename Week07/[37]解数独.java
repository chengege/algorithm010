//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dfs + 回溯 1
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.'){
                    for(char c = '1';c <= '9';c++){
                        if(isValid(board,i,j,c)){ // 验证是否可填
                            board[i][j] = c; // 尝试使用该数

                            if(solve(board))
                                return true;

                            board[i][j] = '.';  // 未解决尝试其他数字
                        }
                    }
                    return false; // 没有数字可填
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,char c){
        for(int i = 0;i < 9;i++){
            if(board[i][col] == c) return false;
            if(board[row][i] == c) return false;
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
    /**
     * dfs + 回溯 2
     */
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private boolean dfs(char[][] board,int level){
        if(level == 81) return true;
        int row = level / 9,col = level % 9;
        if(board[row][col] != '.') return dfs(board,level + 1);

        boolean[] flag = validate(board,row,col);
        for(int i = 1;i <= 9;i++){
            if(flag[i]){
                board[row][col] = (char)('0' + i);
                if(dfs(board,level + 1)) return true;
            }
        }
        board[row][col] = '.';
        return false;

    }
    private boolean[] validate(char[][] board,int row,int col){
        boolean[] flag = new boolean[10];
        Arrays.fill(flag,true);
        for(int i = 0;i < 9;i++){
            if(board[row][i] != '.') flag[board[row][i] - '0'] = false;
            if(board[i][col] != '.') flag[board[i][col] - '0'] = false;
            int rowIndex = row / 3 * 3 + i / 3;
            int colIndex = col / 3 * 3 + i % 3;
            if(board[rowIndex][colIndex] != '.') flag[board[rowIndex][colIndex] - '0'] = false;
        }
        return flag;
    }
    /**
     * Set + dfs
     */
    private class Index{
        public int row;
        public int col;
        public int block;
        public Index(int row,int col,int block){
            this.row = row;
            this.col = col;
            this.block = block;
        }
    }
    public void solveSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] blocks = new Set[9];

        //初始化
        for(int i = 0;i < 9;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            blocks[i] = new HashSet<>();
        }

        // 预处理，填充已有数字，找出空位
        List<Index> empty = new ArrayList<>();
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                char num = board[i][j];
                if(num != '.'){
                    rows[i].add(num);
                    cols[j].add(num);
                    blocks[i / 3 * 3 + j / 3].add(num);
                } else {
                    empty.add(new Index(i,j,i / 3 * 3 + j / 3));
                }
            }
        }
        dfs(board,0,empty,rows,cols,blocks);
    }
    public boolean dfs(char[][] board,
                       int level,
                       List<Index> empty,
                       Set<Character>[] rows,
                       Set<Character>[] cols,
                       Set<Character>[] blocks){
        if(level == empty.size()) return true;
        Index index = empty.get(level);
        Set<Character> row = rows[index.row];
        Set<Character> col = cols[index.col];
        Set<Character> block = blocks[index.block];
        for(char c = '1';c <= '9';c++){
            if(row.contains(c) || col.contains(c) || block.contains(c))
                continue;
            row.add(c);
            col.add(c);
            block.add(c);
            board[index.row][index.col] = c;
            if(dfs(board,level + 1,empty,rows,cols,blocks))
                return true;
            row.remove(c);
            col.remove(c);
            block.remove(c);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
