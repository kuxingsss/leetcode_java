//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 340 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：分发糖果
public class P135Candy {
  public static void main(String[] args) {
    Solution solution = new P135Candy().new Solution();
    // TO TEST
    System.out.println(solution.candy(new int[]{1, 6, 10, 8, 7, 3, 2}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int candy(int[] ratings) {
      int n = ratings.length;
      int ret = 1;
      int inc = 1, dec = 0, pre = 1;
      for (int i = 1; i < n; i++) {
        if (ratings[i] >= ratings[i - 1]) {
          dec = 0;
          pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
          ret += pre;
          inc = pre;
        } else {
          dec++;
          if (dec == inc) {
            dec++;
          }
          ret += dec;
          pre = 1;
        }
      }
      return ret;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}