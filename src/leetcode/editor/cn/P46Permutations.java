//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1036 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：全排列
public class P46Permutations {
  public static void main(String[] args) {
    Solution solution = new P46Permutations().new Solution();
    // TO TEST
    System.out.println(solution.permute(new int[]{1, 2, 3}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
      boolean[] path = new boolean[nums.length];
      List<Integer> out = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        path[i] = true;
        out.add(nums[i]);
        backtrack(out, nums, 1, path);
        path[i] = false;
        out.remove(0);
      }
      return ans;
    }

    private void backtrack(List<Integer> out, int[] nums, int index, boolean[] path) {
      if (index == nums.length) {
        ans.add(new ArrayList<>(out));
        return;
      }
      for (int i = 0; i < nums.length; i++) {
        if (path[i] == true) continue;
        out.add(nums[i]);
        path[i] = true;
        backtrack(out, nums, index + 1, path);
        out.remove(index);
        path[i] = false;
      }
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}