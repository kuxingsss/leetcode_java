//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2879 👎 0

package leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
  public static void main(String[] args) {
    Solution solution = new P5LongestPalindromicSubstring().new Solution();
    // TO TEST
    System.out.println(solution.longestPalindrome("a"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String longestPalindrome(String s) {
      if (s.length() <= 1) return s;
      int[] max = new int[]{0, 0, 1};
      for (int i = 1; i < s.length() - 1; i++) {
        int j = 1;
        while ((i - j) >= 0 && (i + j) <= s.length() - 1) {
          if (s.charAt(i - j) == s.charAt(i + j)) {
            if (2 * j + 1 > max[2]) {
              max[0] = i - j;
              max[1] = i + j;
              max[2] = 2 * j + 1;
            }
            j++;
          } else break;
        }
      }

      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
          int j = 0;
          while ((i - 1 - j) >= 0 && (i + j) <= s.length() - 1) {
            if (s.charAt(i - j - 1) == s.charAt(i + j)) {
              if (2 * j + 2 > max[2]) {
                max[0] = i - j - 1;
                max[1] = i + j;
                max[2] = 2 * j + 2;
              }
              j++;
            } else break;
          }
        }
      }

//      System.out.println("i = " + max[0] + " j = " + max[1]);
      String res = s.substring(max[0], max[1] + 1);
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}