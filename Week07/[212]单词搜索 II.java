//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 198 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word:words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                node = node.getAndSet(c);
            }
            node.setEnd();
        }

        Set<String> res = new HashSet<>();
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                findWords(i,j,board,"",res,root);
            }
        }
        return new ArrayList<>(res);
    }

    public void findWords(int i,int j,char[][] bord,String word,Set<String> res,TrieNode node) {
        if(i < 0 || i >= bord.length || j < 0 || j >= bord[0].length || bord[i][j] == '@') return;

        char temp =  bord[i][j];
        node = node.getNode(temp);
        if(node == null) return;

        word += bord[i][j];
        bord[i][j] = '@'; // 占位，不可重复使用

        if(node.isEnd())
            res.add(word);//找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯

        findWords(i + 1,j,bord,word,res,node);
        findWords(i - 1,j,bord,word,res,node);
        findWords(i,j + 1,bord,word,res,node);
        findWords(i ,j - 1,bord,word,res,node);

        bord[i][j] = temp; // 恢复元素
    }


    private class TrieNode{
        private TrieNode[] nodes;
        private boolean isEnd;

        public TrieNode(){
            nodes = new TrieNode[26];
            isEnd = false;
        }

        public TrieNode getNode(char c){
            return nodes[c - 'a'];
        }

        public TrieNode getAndSet(char c){
            if(nodes[c - 'a'] == null){
                nodes[c - 'a'] = new TrieNode();
            }
            return nodes[c - 'a'];
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
