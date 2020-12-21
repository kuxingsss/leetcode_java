//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 109 
// 0 <= prices.length <= 104 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 316 👎 0

package leetcode.editor.cn;

import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB;

import java.util.Arrays;
import java.util.List;

//Java：买卖股票的最佳时机 IV
public class P188BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
        int[] prices = new int[]{2, 4, 1};
        System.out.println(solution.maxProfit(2, prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (k == 0 || prices.length == 0) return 0;
            if (k >= prices.length / 2) return quickSolve(prices);

            int[][] profit = new int[k + 1][prices.length];

            for (int time = 1; time <= k; time++) {
                int tempMaxProfit = profit[time - 1][0] - prices[0];
                for (int i = 1; i < prices.length; i++) {
                    profit[time][i] = Math.max(profit[time][i - 1], tempMaxProfit + prices[i]);
                    tempMaxProfit = Math.max(tempMaxProfit, profit[time - 1][i - 1] - prices[i]);
                }
            }
            return profit[k][prices.length - 1];
        }

        public int quickSolve(int[] prices) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}