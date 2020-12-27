//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 292 👎 0

package leetcode.editor.cn;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：同构字符串
public class P205IsomorphicStrings{
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
        // TO TEST
        System.out.println(solution.isIsomorphic("paper", "title"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
      public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
          if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
          m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
      }
    }

//leetcode submit region end(Prohibit modification and deletion)

}