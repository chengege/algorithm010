//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

// 前序：根左右 中序：左根右

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
     * 递归
     * 前序：根左右 中序：左根右
     *  前序与中序，左右子树个数相同
     *  前序左子树右节点： x - (preLeft - 1) = (pIndex - 1) - inleft;  pIndex 为中序遍历中根节点位置
     *  前序右子树左节点： 左子树右节点 + 1
     * O(n)
     * O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preRight = preorder.length - 1;
        int inRight = inorder.length - 1;
        Map<Integer,Integer> map = new HashMap<>(); // 缓存中序遍历下标映射，方便查找
        for(int i = 0;i < inorder.length;i++)
            map.put(inorder[i],i);

        return buildTree(preorder,0,preRight,inorder,0,inRight,map);
    }
    public TreeNode buildTree(int[] preorder,int preLeft,int preRight,int[] inorder,int inleft,int inright,Map<Integer,Integer> map) {
        if(preLeft > preRight || inleft > inright){ // 超出边界
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]); // 前序遍历第一个为根节点
        int pIndex = map.get(root.val); // 中序遍历中根节点位置

        root.left = buildTree(preorder,preLeft + 1,pIndex - inleft + preLeft,inorder,inleft,pIndex - 1,map);
        root.right = buildTree(preorder,pIndex - inleft + preLeft + 1,preRight,inorder,pIndex + 1,inright,map);
        return root;
    }


    /**
     * 迭代
     * ttps://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     * O(n)
     * O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
