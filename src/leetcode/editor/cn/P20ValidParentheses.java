//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1953 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("()[]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack();
            Set<Character> set = new HashSet<>();
            set.add('{');
            set.add('[');
            set.add('(');
            Map<Character, Character> map = new HashMap<>();
            map.put('}', '{');
            map.put(')', '(');
            map.put(']', '[');
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || map.get(c) != stack.peek()) stack.push(c);
                    else stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}