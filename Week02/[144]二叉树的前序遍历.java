//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 前序：根-左-右
     * 时间复杂度O(n)
     * 空间复杂度O(logn)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root,res);
        return res;
    }
    public void preorderTraversal(TreeNode node,List<Integer> res){
        if(node != null){
            res.add(node.val);
            if(node.left != null){
                preorderTraversal(node.left,res);
            }
            if(node.right != null){
                preorderTraversal(node.right,res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
