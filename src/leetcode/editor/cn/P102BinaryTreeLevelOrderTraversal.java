//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 674 👎 0

package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> currLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentTreeNode = q.poll();
                    currLevel.add(currentTreeNode.val);

                    if (currentTreeNode.left != null) q.add(currentTreeNode.left);
                    if (currentTreeNode.right != null) q.add(currentTreeNode.right);
                }
                res.add(currLevel);
            }

            return res;
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


}