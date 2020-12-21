//给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。 
//区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。 
//
// 说明: 
//最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。 
//
// 示例: 
//
// 输入: nums = [-2,5,-1], lower = -2, upper = 2,
//输出: 3 
//解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 180 👎 0

package leetcode.editor.cn;

//Java：区间和的个数
public class P327CountOfRangeSum {
    public static void main(String[] args) {
        Solution solution = new P327CountOfRangeSum().new Solution();
        // TO TEST
        int[] nums = new int[]{-2147483647,0,-2147483647,2147483647};
        System.out.println(solution.countRangeSum(nums, -564, 3864));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] sum = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j <= nums.length; j++) {
                    if (sum[j] - sum[i] >= lower && sum[j] - sum[i] <= upper)
                        res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}