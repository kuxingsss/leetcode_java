//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 764 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class P283MoveZeroes {
  public static void main(String[] args) {
    Solution solution = new P283MoveZeroes().new Solution();
    // TO TEST
    int[] nums = {0, 0, 1};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    //双指针解法
    public void moveZeroes(int[] nums) {
      if (nums == null) return;
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j++] = temp;
        }
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}