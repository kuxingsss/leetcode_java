//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 180 👎 0

package leetcode.editor.cn;


import com.sun.xml.internal.bind.v2.model.core.ID;
import jdk.nashorn.internal.objects.NativeUint8Array;

//Java：翻转对
public class P493ReversePairs {
  public static void main(String[] args) {
    Solution solution = new P493ReversePairs().new Solution();
    // TO TEST
    System.out.println(solution.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int reversePairs(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }
      return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
      if (left == right) {
        return 0;
      } else {
        int mid = (left + right) / 2;
        int ret = reversePairsRecursive(nums, left, mid) + reversePairsRecursive(nums, mid + 1, right);

        // 计数
        int i = left;
        int j = mid + 1;
        while (i <= mid) {
          while (j <= right && (long)nums[i] > 2 * (long)nums[j]) j++;
          i++;
          ret += j - mid - 1;
        }
        // 合并
        int p1 = left, p2 = mid + 1, index = 0;
        int[] sorted = new int[right - left + 1];
        while (index <= sorted.length - 1) {
          if (nums[p1] > nums[p2]) sorted[index++] = nums[p2++];
          else sorted[index++] = nums[p1++];
          if (p1 == mid + 1) {
            while (p2 <= right) sorted[index++] = nums[p2++];
          }
          if (p2 == right + 1) {
            while (p1 <= mid) sorted[index++] = nums[p1++];
          }
        }

        for (int k = 0; k < sorted.length; k++) {
          nums[left + k] = sorted[k];
        }

        return ret;
      }
    }
  }

//leetcode submit region end(Prohibit modification and deletion)

}