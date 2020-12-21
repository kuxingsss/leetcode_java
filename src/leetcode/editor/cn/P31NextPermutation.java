//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 810 👎 0

package leetcode.editor.cn;


import java.util.Arrays;

//Java：下一个排列
public class P31NextPermutation {
  public static void main(String[] args) {
    Solution solution = new P31NextPermutation().new Solution();
    // TO TEST
    int[] nums = new int[]{1, 1};
    solution.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public void nextPermutation(int[] nums) {
      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i + 1]) i--;

      if (i >= 0) {
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) j--;
        swap(i, j, nums);
      }
      Arrays.sort(nums, i + 1, nums.length);
    }


    private void swap(int i, int j, int[] nums) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;

    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}