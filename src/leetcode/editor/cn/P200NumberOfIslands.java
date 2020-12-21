//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 836 👎 0

package leetcode.editor.cn;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.Arrays;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] moveRow = new int[]{-1, 1, 0, 0};
        int[] moveCol = new int[]{0, 0, -1, 1};

        public int numIslands(char[][] grid) {
            if (grid[0].length == 0) return 0;
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == '1') {
                        count += dfs(row, col, grid);
                    }


                }
            }
            return count;
        }

        public int dfs(int row, int col, char[][] grid) {
            if (!isVaild(row, col, grid)) return 0;
            grid[row][col] = '0';
            for (int i = 0; i < 4; i++) {
                dfs(row + moveRow[i], col + moveCol[i], grid);
            }
            return 1;
        }

        public boolean isVaild(int row, int col, char[][] grid) {
            if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) return false;
            if (grid[row][col] == '0') return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}