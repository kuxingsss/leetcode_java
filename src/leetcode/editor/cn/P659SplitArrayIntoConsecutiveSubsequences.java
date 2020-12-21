//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 153 👎 0

package leetcode.editor.cn;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

//Java：分割数组为连续子序列
public class P659SplitArrayIntoConsecutiveSubsequences {
  public static void main(String[] args) {
    Solution solution = new P659SplitArrayIntoConsecutiveSubsequences().new Solution();
    // TO TEST
    System.out.println(solution.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isPossible(int[] nums) {
      int pre = Integer.MIN_VALUE;
      int p1 = 0;
      int p2 = 0;
      int p3 = 0;

      int cur = 0;
      int cnt = 0;
      int c1 = 0;
      int c2 = 0;
      int c3 = 0;

      for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
        for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++) {
          cnt++;
        }

        if (cur != pre + 1) {
          if (p1 != 0 || p2 != 0) {
            return false;
          }

          c1 = cnt;
          c2 = 0;
          c3 = 0;

        } else {
          if (cnt < p1 + p2) {
            return false;
          }

          c1 = Math.max(0, cnt - (p1 + p2 + p3));
          c2 = p1;
          c3 = p2 + Math.min(p3, cnt - (p1 + p2));
        }
      }

      return (p1 == 0 && p2 == 0);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}