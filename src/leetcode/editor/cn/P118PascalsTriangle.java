//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 407 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角
public class P118PascalsTriangle{
  public static void main(String[] args) {
    Solution solution = new P118PascalsTriangle().new Solution();
    // TO TEST
    System.out.println(solution.generate(5));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<>();
      if (numRows == 0) return ans;
      List<Integer> firstRow = new ArrayList<>();
      firstRow.add(1);
      ans.add(firstRow);

      for (int i = 1; i < numRows; i++) {
        List<Integer> curRow = new ArrayList<>();
        curRow.add(1);
        for (int j = 0; j < i - 1; j++) {
          int num = ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1);
          curRow.add(num);
        }
        curRow.add(1);
        ans.add(curRow);
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}