//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 346 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：单词拆分 II
public class P140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new P140WordBreakIi().new Solution();
        // TO TEST
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(solution.wordBreak("pineapplepenapple", wordDict));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            return dfs(s, wordDict, new HashMap<String, List<String>>());
        }

        private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> mem) {
            if (mem.containsKey(s)) return mem.get(s);
            List<String> result = new ArrayList<>();
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    String next = s.substring(word.length());
                    if (next.length() == 0) result.add(word);
                    else {
                        //这里的dfs会返回剩余几种可能的的字符串
                        for (String sub : dfs(next, wordDict, mem)) result.add(word + " " + sub);
                    }
                }
            }
            mem.put(s, result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//   pineapplepenapple
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
}