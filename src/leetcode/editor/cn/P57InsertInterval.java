//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 248 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：插入区间
public class P57InsertInterval {
    public static void main(String[] args) {
        Solution solution = new P57InsertInterval().new Solution();
        // TO TEST
        //{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{2, 7};
        int[][] res = solution.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
            List<int[]> tempList = new ArrayList<>();
            int left = newInterval[0], right = newInterval[1];
            boolean find = false;
            for (int[] interval : intervals) {
                if (interval[0] > right) {
                    if (!find) {
                        tempList.add(new int[]{left, right});
                        find = true;
                    }
                    tempList.add(interval);
                } else if (interval[1] < left) {
                    tempList.add(interval);
                }
                else {
                    left = Math.min(left, interval[0]);
                    right = Math.max(right, interval[1]);
                }
            }
            if (!find) tempList.add(new int[]{left, right});

            int[][] res = new int[tempList.size()][2];
            for (int i = 0; i < tempList.size(); i++) {
                res[i] = tempList.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}