//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 435 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：有效的数独
public class P36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36ValidSudoku().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int row = 0; row < board.length; row++) {
                Set<Character> colFilter = new HashSet<>();
                Set<Character> rowFilter = new HashSet<>();
                int colCount = 0;
                int rowCount = 0;
                for (int col = 0; col < board.length; col++) {
                    //行列检测
                    if (board[row][col] != '.') {
                        colCount++;
                        colFilter.add(board[row][col]);

                    }
                    if (board[col][row] != '.'){
                        rowCount++;
                        rowFilter.add(board[col][row]);
                    }
                }
                if (colFilter.size() != colCount) return false;
                if (rowFilter.size() != rowCount) return false;
            }

            int minLine = board.length / 3;

            for (int minRow = 0; minRow < minLine; minRow++) {
                for (int minCol = 0; minCol < minLine; minCol++) {
                    Set<Character> minMatrixFilter = new HashSet<>();
                    int minMatrixCount = 0;
                    for (int row = minRow * 3; row < (minRow + 1) * 3; row++) {
                        for (int col = minCol * 3; col < (minCol + 1) * 3; col++) {
                            if (board[row][col] == '.') continue;
                            minMatrixFilter.add(board[row][col]);
                            minMatrixCount++;
                        }
                    }
                    if (minMatrixFilter.size() != minMatrixCount) return false;
                }
            }


            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}