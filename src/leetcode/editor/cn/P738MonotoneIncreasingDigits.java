//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 97 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//Java：单调递增的数字
public class P738MonotoneIncreasingDigits {
  public static void main(String[] args) {
    Solution solution = new P738MonotoneIncreasingDigits().new Solution();
    // TO TEST
    System.out.println(solution.monotoneIncreasingDigits(12342));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int monotoneIncreasingDigits(int N) {
      LinkedList<Integer> listN = new LinkedList<>();
      while (N > 0) {
        int bitN = N % 10;
        listN.addFirst(bitN);
        N /= 10;
      }
//      System.out.println(listN);
      int i = 0, ans = 0;
      for (; i < listN.size() - 1; i++) {
        if (listN.get(i) < listN.get(i + 1)) {
          ans = ans * 10 + listN.get(i);
        } else if (listN.get(i) == listN.get(i + 1)) {
          int detect = i + 2;
          while (detect < listN.size() - 1 && listN.get(detect) == listN.get(i)) {
            detect++;
          }
          if (detect == listN.size()) {
            while (i < listN.size()) {
              ans = ans * 10 + listN.get(i);
              i++;
            }
          } else if (listN.get(detect) < listN.get(i)) {
            ans = add(i, listN, ans);
            break;
          } else if (listN.get(detect) > listN.get(i)) {
            ans = ans * 10 + listN.get(i);
          }
        } else {
          ans = add(i, listN, ans);
          break;
        }
        if (i == listN.size() - 2) {
          ans = ans * 10 + listN.get(i + 1);
        }
      }
      return ans;
    }

    public int add(int i, LinkedList<Integer> listN, int ans) {
      if (listN.get(i) > 1) {
        ans = ans * 10 + (listN.get(i) - 1);
      }
      i++;
      while (i < listN.size()) {
        ans = ans * 10 + 9;
        i++;
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}