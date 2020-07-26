//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 双重遍历+dfs
     * 遇到1时将旁边所有的1都置为0
     * O(M N) M 和 N 分别为行数和列数。
     * O(M N)
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        int wide = grid.length;
        int height = grid[0].length;
        for(int i = 0;i < wide;i++){
            for(int j = 0;j < height;j++){
                if(grid[i][j] == '1'){
                    ++count;
                    dfs(grid,i,j,wide,height);//使用dfs将1置为0
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int i,int j,int wide,int height){
        // 越界或者当前为0
        if(i < 0 || j < 0 || i >= wide || j >= height || grid[i][j] == '0')
            return;

            grid[i][j] = '0';
        // 遍历其他相邻节点
        dfs(grid,i - 1,j,wide,height);
        dfs(grid,i + 1,j,wide,height);
        dfs(grid,i,j - 1,wide,height);
        dfs(grid,i,j + 1,wide,height);
    }

    /**
     * 广度优先搜索
     * O(MN) M 和 N 分别为行数和列数。
     * O(n) M 和 N 分别为行数和列数。
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        int wide = grid.length;
        int height = grid[0].length;

        for(int i = 0;i < wide;i++){
            for(int j = 0;j < height;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    count++;
                    Queue<Integer> temp = new LinkedList<>();
                    temp.add(i * height + j);
                    while(!temp.isEmpty()){
                        int id = temp.remove();
                        int row = id / height;
                        int col = id % height;

                        if(row - 1 >= 0 && grid[row - 1][col] == '1'){
                            grid[row - 1][col] = '0';
                            temp.add((row - 1) * height + col);
                        }

                        if(row + 1 < wide && grid[row + 1][col] == '1'){
                            grid[row + 1][col] = '0';
                            temp.add((row + 1) * height + col);
                        }

                        if(col - 1 >= 0 && grid[row][col - 1] == '1'){
                            grid[row][col - 1] = '0';
                            temp.add((row) * height + col - 1);
                        }

                        if(col + 1 < height && grid[row][col + 1] == '1'){
                            grid[row][col + 1] = '0';
                            temp.add((row) * height + col + 1);
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 并查集
     */
    private class UnionFind{
        private int[] parent;
        private int count;

        public UnionFind(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    if(grid[i][j] == '1'){
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }

        }

        public int find(int p){
            while (parent[p] != p){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int count(){
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < col;j++){
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if(i - 1 >= 0 && grid[i - 1][j] == '1')
                        uf.union(i * col + j,(i - 1) * col + j);

                    if(i + 1 < row && grid[i + 1][j] == '1')
                        uf.union(i * col + j,(i + 1) * col + j);

                    if(j - 1 >= 0 && grid[i][j - 1] == '1')
                        uf.union(i * col + j,i * col + j - 1);

                    if(j + 1 < col && grid[i][j + 1] == '1')
                        uf.union(i * col + j,i * col + j + 1);
                }
            }
        }
        return uf.count();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
