//给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都
//可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。 
//
// 示例 1: 
//
// 输入: nums = [1,3], n = 6
//输出: 1 
//解释:
//根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
//现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
//其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
//所以我们最少需要添加一个数字。 
//
// 示例 2: 
//
// 输入: nums = [1,5,10], n = 20
//输出: 2
//解释: 我们需要添加 [2, 4]。
// 
//
// 示例 3: 
//
// 输入: nums = [1,2,2], n = 5
//输出: 0
// 
// Related Topics 贪心算法 
// 👍 160 👎 0

package leetcode.editor.cn;

//Java：按要求补齐数组
public class P330PatchingArray {
  public static void main(String[] args) {
    Solution solution = new P330PatchingArray().new Solution();
    // TO TEST
    System.out.println(solution.minPatches(new int[]{1,5,10}, 20));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int minPatches(int[] nums, int n) {
      //累加的总和
      long total = 1;
      //需要补充的数字个数
      int count = 0;
      //访问的数组下标索引
      int index = 0;
      while (total <= n) {
        if (index < nums.length && nums[index] <= total) {
          //如果数组能组成的数字范围是[1,total]，那么加上nums[index]
          //就变成了[1,total]U[nums[index],total+nums[index]]
          //结果就是[1,total+nums[index]]
          total += nums[index++];
        } else {
          //添加一个新数字，并且count加1
          total <<= 1;
          count++;
        }
      }
      return count;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}