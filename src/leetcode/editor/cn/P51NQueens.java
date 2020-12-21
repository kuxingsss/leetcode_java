//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 653 👎 0

package leetcode.editor.cn;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import javax.sound.midi.Track;
import java.util.*;

//Java：N 皇后
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
        List<List<String>> res = solution.solveNQueens(8);
        System.out.println(res);
        System.out.println(res.size());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>(n);
            int[] queensMatrix = new int[n];
            Arrays.fill(queensMatrix, -1);
            Set<Integer> col = new HashSet<>(4);
            helper(result, queensMatrix, col, 0, new boolean[2 * n], new boolean[2 * n]);

            return result;
        }

        public void helper(List<List<String>> result, int[] queensMatrix, Set<Integer> col, int currentDeep,
                           boolean[] pie, boolean[] na) {
            int n = queensMatrix.length;
            if (currentDeep == n) {
                //把queensMatrix转化成输出矩阵
                result.add(genResult(queensMatrix.length, queensMatrix));
                return;
            }
            for (int row = 0; row < n; row++) {
                int left = currentDeep + row;
                int right = currentDeep - row + queensMatrix.length;
                if (!pie[left] && !na[right] && !col.contains(row)) {
                    pie[left] = true;
                    na[right] = true;
                    queensMatrix[currentDeep] = row;
                    col.add(row);
                    helper(result, queensMatrix, col, currentDeep + 1, pie, na);
                    pie[left] = false;
                    na[right] = false;
                    queensMatrix[currentDeep] = -1;
                    col.remove(row);
                }
            }
        }

        public List<String> genResult(int n, int[] queensMatrix) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queensMatrix[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}