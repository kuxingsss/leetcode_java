//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 613 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

//Java：根据身高重建队列
public class P406QueueReconstructionByHeight {
  public static void main(String[] args) {
    Solution solution = new P406QueueReconstructionByHeight().new Solution();
    // TO TEST
    int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    System.out.println(Arrays.deepToString(solution.reconstructQueue(people)));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] reconstructQueue(int[][] people) {
      Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
      LinkedList<int[]> list = new LinkedList<>();
      for (int[] arr : people) {
        list.add(arr[1], arr);
      }
      return list.toArray(people);
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}