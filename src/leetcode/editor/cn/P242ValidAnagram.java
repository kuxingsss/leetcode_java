//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 266 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java：有效的字母异位词
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
        boolean res = solution.isAnagram("anagram", "nagaram");
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> countS = new HashMap<>(26);
//        HashMap<Character, Integer> countT = new HashMap<>(26);
//            int lenS = s.length(), lenT = t.length();
//            if (lenS != lenT) {
//                return false;
//            }
//            for (int i = 0; i < lenS; i++) {
//                char charS = s.charAt(i);
//                char charT = t.charAt(i);
//                if (countS.get(charS) == null) {
//                    countS.put(charS, 1);
//                }
//                else {
//                    countS.replace(charS, countS.get(charS) + 1);
//                }
//                if (countT.get(charT) == null) {
//                    countT.put(charT, 1);
//                }
//                else {
//                    countT.replace(charT, countT.get(charT) + 1);
//                }
//            }
//        return countS.equals(countT);
            int[] countListS = new int[26];
            int[] countListT = new int[26];
            int lenS = s.length(), lenT = t.length();
            if (lenS != lenT) {
                return false;
            }
            for (int i = 0; i < lenS; i++) {
                countListS[s.charAt(i) - 'a']++;
                countListT[t.charAt(i) - 'a']++;
            }
            return Arrays.equals(countListS, countListT);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}