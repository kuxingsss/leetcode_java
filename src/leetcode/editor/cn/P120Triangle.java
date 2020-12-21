//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 630 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三角形最小路径和
public class P120Triangle {
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int deep = triangle.size();
            int[] minPath = new int[deep + 1];
            for (int row = deep - 1; row >= 0; row--) {
                for (int col = 0; col <= row; col++) {
                    minPath[col] = Math.min(minPath[col], minPath[col + 1]) + triangle.get(row).get(col);
                }
            }
            return minPath[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}