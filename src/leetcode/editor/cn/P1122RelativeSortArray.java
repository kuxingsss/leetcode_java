//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 116 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：数组的相对排序
public class P1122RelativeSortArray {
  public static void main(String[] args) {
    Solution solution = new P1122RelativeSortArray().new Solution();
    // TO TEST
    int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
    int[] res = solution.relativeSortArray(arr1, arr2);
    System.out.println(Arrays.toString(res));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      if (arr1.length == 0 || arr2.length == 0) return arr1;
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> lastNum = new ArrayList<>();
      Set<Integer> set = new HashSet<>();

      for (int num : arr2) set.add(num);
      for (int i = 0; i < arr1.length; i++) {
        if (set.contains(arr1[i])) {
          map.merge(arr1[i], 1, (oldValue, newValue) -> oldValue + newValue);
          arr1[i] = 0;
        }
      }
      Arrays.sort(arr1);
      int i = 0, j;
      for (int num : arr2) {
        j = i + map.get(num);
        Arrays.fill(arr1, i, j, num);
        i = j;
      }
      return arr1;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}