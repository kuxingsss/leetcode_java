//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。
//
//
//
// 进阶：
//
// 你能在线性时间复杂度内解决此题吗？
//
//
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 601 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum {
  public static void main(String[] args) {
    Solution solution = new P239SlidingWindowMaximum().new Solution();
    // TO TEST
    int[] nums = {7, 2, 4};
    int k = 2;
    int[] res = solution.maxSlidingWindow(nums, k);
    System.out.println(Arrays.toString(res));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int len = nums.length, index = 0;
      if (len * k == 0) return new int[0];
      if (k == 1) return nums;

      ArrayDeque<Integer> window = new ArrayDeque<>();
      int[] res = new int[len - k + 1];

      for (int i = 0; i < len; i++) {
        if (window.size() != 0 && window.getFirst() <= i - k) {
          window.removeFirst();
        }
        while (window.size() != 0 && nums[window.getLast()] <= nums[i]) {
          window.removeLast();
        }
        window.addLast(i);
        if (i >= k - 1) {
          res[index++] = nums[window.getFirst()];
        }
      }
      return res;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)
//class Solution {
//
//  public int[] maxSlidingWindow(int[] nums, int k) {
//    int n = nums.length;
//    int resIndex = 0;
//    ArrayDeque<Integer> window = new ArrayDeque<>();
//    int[] res = new int[n - k + 1];
//    if (n * k == 0) {
//      return new int[0];
//    }
//    if (k == 1){
//      return nums;
//    }
//    for (int i = 0; i < n; i++) {
//
//      if (window.size() != 0 && window.getFirst() <= i - k) {
//        window.removeFirst();
//      }
//      while (window.size() != 0 && nums[window.getLast()] <= nums[i]) {
//        window.removeLast();
//      }
//      window.addLast(i);
//      if (i >= k - 1) {
//        res[resIndex++] = nums[window.getFirst()];
//      }
//    }
//    return res;
//  }
//}
}