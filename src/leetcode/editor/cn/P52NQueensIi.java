//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 203 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：N皇后 II
public class P52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        // TO TEST
        System.out.println(solution.totalNQueens(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            return dfs(n, 0, 0, 0, 0);
        }

        public int dfs(int n, int row, int col, int pie, int na) {
            if (row == n) return 1;
            int count = 0;
            int bits = (~(col | pie | na) & (1 << n) - 1);
            while (bits > 0) {
                int p = bits & (-bits);
                count += dfs(n, row + 1,col | p, (pie | p) << 1, (na | p) >> 1 );
                bits &= (bits - 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//class Solution {
//    public int totalNQueens(int n) {
//        int res = helper(0, new HashSet<Integer>(n), new boolean[n * 2], new boolean[n * 2], n);
//        return res;
//    }
//
//    public int helper(int currentDeep, Set<Integer> col, boolean[] pie, boolean[] na, int n) {
//        if (currentDeep == n) {
//            return 1;
//        }
//        int count = 0;
//        for (int row = 0; row < n; row++) {
//            int left = currentDeep + row;
//            int right = currentDeep - row + n;
//            if (!pie[left] && !na[right] && !col.contains(row)) {
//                pie[left] = true;
//                na[right] = true;
//                col.add(row);
//                count += helper(currentDeep + 1, col, pie, na, n);
//                pie[left] = false;
//                na[right] = false;
//                col.remove(row);
//            }
//        }
//        return count;
//    }
//}