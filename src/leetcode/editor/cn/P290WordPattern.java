//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 239 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：单词规律
public class P290WordPattern {
  public static void main(String[] args) {
    Solution solution = new P290WordPattern().new Solution();
    // TO TEST
    System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean wordPattern(String pattern, String s) {
      int left = 0;
      List<String> list = new ArrayList<>();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
          list.add(s.substring(left, i));
          left = i + 1;
        }
        if (i == s.length() - 1) {
          list.add(s.substring(left, i + 1));
        }
      }
      if (pattern.length() != list.size()) return false;
//      System.out.println(list);
      Map<Character, String> map = new HashMap<>();
      Set<String > set = new HashSet<>();
      for (int i = 0; i < pattern.length(); i++) {
        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
          if (!map.get(c).equals(list.get(i))) {
            return false;
          }
        } else {
          if (set.contains(list.get(i))) {
            return false;
          }
          map.put(c, list.get(i));
          set.add(list.get(i));
        }
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}