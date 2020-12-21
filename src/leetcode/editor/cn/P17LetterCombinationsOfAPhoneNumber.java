//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 1022 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
  public static void main(String[] args) {
    Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
    // TO TEST
    System.out.println(solution.letterCombinations("23"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<String> letterCombinations(String digits) {
      LinkedList<String> ans = new LinkedList<String>();
      if (digits.isEmpty()) return ans;
      String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      ans.add("");
      for (int i = 0; i < digits.length(); i++) {
        int x = Character.getNumericValue(digits.charAt(i));
        while (ans.peek().length() == i) {
          String t = ans.remove();
          for (char s : mapping[x].toCharArray())
            ans.add(t + s);
        }
      }
      return ans;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}