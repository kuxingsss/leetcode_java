//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 817 👎 0

package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.*;

//Java：验证二叉搜索树
public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
//        public boolean isValidBST(TreeNode root) {
//            return helper(root, null, null);
//        }
        public boolean isValidBST(TreeNode root, Integer min, Integer max){
            if (root == null) return true;
            if (root != null && root.val >= max) return false;
            if (root != null && root.val <= min) return false;
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//            Deque<TreeNode> stack = new LinkedList<>();
//            double inorder = -Double.MAX_VALUE;
//            while (!stack.isEmpty() || root != null) {
//                while (root != null) {
//                    stack.push(root);
//                    root = root.left;
//                }
//                root = stack.pop();
//                if (root.val <= inorder) {
//                    return false;
//                }
//                inorder = root.val;
//                root = root.right;
//            }
//            return true;
}