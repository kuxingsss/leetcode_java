//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 132 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：翻转矩阵后的得分
public class P861ScoreAfterFlippingMatrix {
  public static void main(String[] args) {
    Solution solution = new P861ScoreAfterFlippingMatrix().new Solution();
    // TO TEST
    int ans = solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
    System.out.println(ans);
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int matrixScore(int[][] A) {
      int rows = A.length;
      if (rows == 0 || rows == 0) return 0;

      for (int i = 0; i < rows; i++) {
        if (A[i][0] == 1) continue;
        else {
          A[i][0] = 1;
          for (int j = 1; j < A[0].length; j++) {
            if (A[i][j] == 1) A[i][j] = 0;
            else A[i][j] = 1;
          }
        }
      }
      int ans = (int) (rows * Math.pow(2, A[0].length - 1));

      for (int col = 1; col < A[0].length; col++) {
        int count = 0;
        for (int row = 0; row < rows; row++) {
          if (A[row][col] == 1) count++;
        }
        if (count < (rows + 1) / 2) {
          count = rows - count;
        }
        ans += count * Math.pow(2, A[0].length - col - 1);
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}