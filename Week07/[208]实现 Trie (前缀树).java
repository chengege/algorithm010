//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private class Node{
        private Node[] nodes;
        private boolean isEnd;

        public Node(){
            nodes = new Node[26];
            isEnd = false;
        }

        public Node getNode(char c){
            return nodes[c - 'a'];
        }

        public Node getAndSet(char c){
            if(nodes[c - 'a'] == null){
                nodes[c - 'a'] = new Node();
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
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            node = node.getAndSet(c);
        }
        node.setEnd();
    }

    private Node searchPre(String word){
        Node node = root;
        for(char c : word.toCharArray()){
            node = node.getNode(c);
            if(node == null) break;
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchPre(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPre(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
