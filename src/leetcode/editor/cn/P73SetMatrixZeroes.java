//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组 
// 👍 326 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：矩阵置零
public class P73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
        // TO TEST
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int col0 = 1, rowLen = matrix.length, colLen = matrix[0].length;
            for (int i = 0; i < rowLen; i++) {
                if (matrix[i][0] == 0) col0 = 0;
                for (int j = 1; j < colLen; j++) {
                    if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
                }
            }
            System.out.println(Arrays.deepToString(matrix));
            for (int i = rowLen - 1; i >= 0; i--) {
                for (int j = colLen - 1; j >= 1; j--) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }
                if (col0 == 0) matrix[i][0] = 0;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}