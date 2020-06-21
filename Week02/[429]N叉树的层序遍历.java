//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /**
     * 递归
     * O(n)
     * O(n)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root,0,res);
        return res;
    }
    public void levelOrder(Node node,int level,List<List<Integer>> res) {
        if(res.size() <= level) res.add(new ArrayList<>());
        if(node != null){
            res.get(level).add(node.val);
            for(Node child:node.children){
                levelOrder(node,++level,res);
            }
        }
    }

    /**
     * 利用队列实现广度优先搜索
     * O(n)
     * O(n)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> levelRes = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i < size;i++){
                Node cur = queue.poll();
                levelRes.add(cur.val);
                queue.addAll(cur.children);
            }
            res.add(levelRes);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
