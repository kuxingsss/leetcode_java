//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 577 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：前 K 个高频元素
public class P347TopKFrequentElements{
  public static void main(String[] args) {
    Solution solution = new P347TopKFrequentElements().new Solution();
    // TO TEST
    int[] ans = solution.topKFrequent(new int[]{1}, 1);

    System.out.println(Arrays.toString(ans));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return o1[1] - o2[1];
        }
      });

      Map<Integer, Integer> intersection = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        intersection.merge(nums[i], 1, (oldValue, newValue) -> oldValue + newValue);
      }

      Set<Integer> set = intersection.keySet();
      for (int num : set) {
        int[] item = {num, intersection.get(num)};
        queue.add(item);
        if (queue.size() > k) queue.poll();
      }
      int[] ans = new int[k];
      for (int i = 0; i < k; i++) {
        ans[i] = queue.poll()[0];
      }
      return ans;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}