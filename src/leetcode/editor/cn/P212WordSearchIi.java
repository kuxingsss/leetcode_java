//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 271 👎 0

package leetcode.editor.cn;

import sun.nio.cs.ext.TIS_620;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词搜索 II
public class P212WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new P212WordSearchIi().new Solution();
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        // TO TEST
        System.out.println(solution.findWords(board, words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> res = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            int i = board.length;
            int j = board[0].length;
            boolean[][] visited = new boolean[i][j];
            for (int row = 0; row < i; row++) {
                for (int col = 0; col < j; col++) {
                    dfs(board, visited, row, col, trie, "");
                }
            }

            return new ArrayList<>(res);
        }

        public void dfs(char[][] board, boolean[][] visited, int row, int col, Trie trie, String str) {
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
            if (visited[row][col]) return;
            str += board[row][col];
            if (!trie.startsWith(str)) return;
            if (trie.search(str)) res.add(str);

            visited[row][col] = true;
            dfs(board, visited, row - 1, col, trie, str);
            dfs(board, visited, row + 1, col, trie, str);
            dfs(board, visited, row, col - 1, trie, str);
            dfs(board, visited, row, col + 1, trie, str);
            visited[row][col] = false;
        }
    }



    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) ws.children[c - 'a'] = new TrieNode(c);
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }


        public boolean startsWith(String prefix) {
            TrieNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (ws.children[c - 'a'] == null) return false;
                ws = ws.children[c - 'a'];
            }
            return true;
        }

    }

    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {

        }

        public TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}