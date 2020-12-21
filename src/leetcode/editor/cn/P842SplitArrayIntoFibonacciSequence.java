//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 138 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：将数组拆分成斐波那契序列
public class P842SplitArrayIntoFibonacciSequence {
  public static void main(String[] args) {
    Solution solution = new P842SplitArrayIntoFibonacciSequence().new Solution();
    // TO TEST
    System.out.println();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
      List<Integer> ans = new ArrayList<>();
      backtrack(S.toCharArray(), ans, 0);
      return ans;
    }

    private long subDigit(char[] digit, int start, int end) {
      long res = 0;
      for (int i = start; i < end; i++) {
        res = res * 10 + digit[i] - '0';
      }
      return res;
    }

    private boolean backtrack(char[] digit, List<Integer> ans, int index) {
      if (index == digit.length && ans.size() >= 3) return true;
      for (int i = index; i < digit.length; i++) {
        if (digit[index] == '0' && i > index) break;

        long num = subDigit(digit, index, i + 1);
        if (num > Integer.MAX_VALUE) break;

        int size = ans.size();
        if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) break;
        if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
          //把数字num添加到集合res中
          ans.add((int) num);
          //如果找到了就直接返回
          if (backtrack(digit, ans, i + 1)) return true;
          //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
          ans.remove(ans.size() - 1);
        }
      }
      return false;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}