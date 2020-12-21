//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 223 👎 0

package leetcode.editor.cn;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.*;

//Java：拼接最大数
public class P321CreateMaximumNumber {
  public static void main(String[] args) {
    Solution solution = new P321CreateMaximumNumber().new Solution();
    // TO TEST
    int ans[] = solution.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
    System.out.println(Arrays.toString(ans));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
      int len1 = nums1.length, len2 = nums2.length;
      int[] ans = new int[k];

      for (int i = Math.max(0, k - len2); i <= len1 && i <= k; i++) {
        int[] temp = mergeNums(pickMax(nums1, i), pickMax(nums2, k - i));
        if (compareTo(temp, ans, 0, 0)) ans = temp;
      }
      return ans;
    }

    public int[] pickMax(int[] nums, int k) {
      LinkedList<Integer> ans = new LinkedList<>();
      int[] res = new int[k];
      if (k == 0) return res;
      if (k == nums.length) return nums;

      ans.add(nums[0]);
      k--;
      for (int i = 1; i < nums.length; i++) {
        while (!ans.isEmpty() && ans.peekLast() < nums[i] && (nums.length - i) > k) {
          ans.pollLast();
          k++;
        }
        if (k > 0) {
          ans.addLast(nums[i]);
          k--;
        }
      }
      for (int i = 0; i < ans.size(); i++) {
        res[i] = ans.get(i);
      }
      return res;
    }

    public int[] mergeNums(int[] nums1, int[] nums2) {
      int len1 = nums1.length, len2 = nums2.length;
      int[] ans = new int[len1 + len2];
      if (nums1.length == ans.length) ans = nums1;
      else if (nums2.length == ans.length) ans = nums2;
      else {
        int index1 = 0, index2 = 0, index = 0;
        while (index < len1 + len2 - 1) {
          if (compareTo(nums1, nums2, index1, index2)) {
            ans[index++] = nums1[index1++];
          } else ans[index++] = nums2[index2++];
          if (index1 >= len1) {
            while (index2 < len2) ans[index++] = nums2[index2++];
          }
          if (index2 >= len2) {
            while (index1 < len1) ans[index++] = nums1[index1++];
          }
        }
      }

      return ans;
    }

    public boolean compareTo(int[] num1, int[] num2, int index1, int index2) {
      while (index1 < num1.length && index2 < num2.length) {
        if (num1[index1] > num2[index2]) return true;
        if (num1[index1] < num2[index2]) return false;
        index1++;
        index2++;
      }
      if (index1 >= num1.length) return false;
      else return true;
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}