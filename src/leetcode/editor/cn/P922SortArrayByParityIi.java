//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 181 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：按奇偶排序数组 II
public class P922SortArrayByParityIi {
  public static void main(String[] args) {
    Solution solution = new P922SortArrayByParityIi().new Solution();
    // TO TEST
    int[] nums = new int[]{4 ,2, 5, 7};
    int[] res = solution.sortArrayByParityII(nums);
    System.out.println(Arrays.toString(res));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] sortArrayByParityII(int[] A) {
      if (A.length <= 1) return new int[0];
      int odd = 1, even = 0;
      int[] res = new int[A.length];
      for (int i = 0; i < A.length; i++) {
        if ((A[i] & 1) == 1) {
          res[odd] = A[i];
          odd += 2;
        } else {
          res[even] = A[i];
          even += 2;
        }
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}