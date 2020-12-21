//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 672 👎 0

package leetcode.editor.cn;

import javax.xml.ws.EndpointReference;

//Java：解数独
public class P37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            if (board.length != 9 || board == null) return;
            solve(board);
        }

        public boolean solve(char[][] board) {
            int lineLen = board.length;
            for (int row = 0; row < lineLen; row++) {
                for (int col = 0; col < lineLen; col++) {
                    if (board[row][col] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isVaild(board, row, col, c)) {
                                board[row][col] = c;
                                if (solve(board)) return true;
                                else board[row][col] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isVaild(char[][] board, int row, int col, char c) {
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] == c) return false;
                if (board[i][col] == c) return false;
                if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}