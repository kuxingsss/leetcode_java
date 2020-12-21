//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 909 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：子集
public class P78Subsets {
  public static void main(String[] args) {
    Solution solution = new P78Subsets().new Solution();
    // TO TEST
    System.out.println(solution.subsets(new int[]{1, 5, 3}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
      backtrack(0, nums);
      return ans;
    }

    public void backtrack(int cur, int[] nums) {
      ans.add(new ArrayList<>(temp));
      for (int i = cur; i < nums.length; i++) {
        temp.add(nums[i]);
        backtrack(i + 1, nums);
        temp.remove(temp.size() - 1);
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}