//给你一个整数数组 nums ，和一个整数 target 。 
//
// 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
// ）。 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1091 👎 0

package leetcode.editor.cn;

//Java：搜索旋转排序数组
public class P33SearchInRotatedSortedArray {
  public static void main(String[] args) {
    Solution solution = new P33SearchInRotatedSortedArray().new Solution();
    // TO TEST
    System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int search(int[] nums, int target) {
      if (nums[0] == target) return 0;
      if (target < nums[0]) {
        for (int i = nums.length - 1; i >= 0; i--) {
          if (nums[i] > nums[0]) return -1;
          if (nums[i] == target) return i;
        }
      } else {
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] < nums[0]) return -1;
          if (nums[i] == target) return i;
        }
      }


      return -1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}