//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1384 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {

            List<String> list = new ArrayList<>();
            gen(list, "", n, n);
            return list;
        }

        public void gen(List<String> list, String subList, int left, int right) {
            if (left == 0 && right == 0) {
                list.add(subList);
                return;
            }
            if (left > 0) gen(list, subList + "(", left - 1, right);
            if (right > left) gen(list, subList + ")", left, right - 1);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}