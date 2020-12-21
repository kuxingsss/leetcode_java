//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 625 👎 0

package leetcode.editor.cn;

import org.omg.Messaging.SyncScopeHelper;

import java.util.*;

//Java：单词接龙
public class P127WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(solution.ladderLength("hit", "cog", wordList));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        Map<String, List<String>> edge = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;

            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);

            Queue<String> queBegin = new LinkedList<>();
            queBegin.offer(beginWord);

            Map<String, Integer> path = new HashMap<>();
            path.put(beginWord, 0);
            while (!queBegin.isEmpty()) {
                String curWord = queBegin.poll();
                set.remove(curWord);
                if (curWord == endWord) return path.get(endWord) / 2 + 1;
                for (String it : edge.get(curWord)) {
                    if (set.contains(it)){
                        queBegin.offer(it);
                        path.put(it, path.get(curWord) + 1);
                    }
                }
            }
            return 0;
        }

        private void addEdge(String word) {
            addWord(word);
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                chars[i] = '*';
                String newWord = new String(chars);
                addWord(newWord);
                edge.get(word).add(newWord);
                edge.get(newWord).add(word);
                chars[i] = temp;
            }
        }

        private void addWord(String word) {
            if (!set.contains(word)) {
                set.add(word);
                edge.put(word, new ArrayList<String>());
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}