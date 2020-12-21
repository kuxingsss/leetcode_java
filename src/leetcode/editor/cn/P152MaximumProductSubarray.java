//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 818 👎 0

package leetcode.editor.cn;

//Java：乘积最大子数组
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null) return 0;

            int res = nums[0], curMax = nums[0], curMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                int temp = curMax;
                curMax = Math.max(temp * num, Math.max(curMin * num, num));
                curMin = Math.min(temp * num, Math.min(curMin * num, num));
                res = Math.max(res, curMax);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}