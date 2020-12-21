//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5196 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

//Java：两数相加
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode temp, res = new ListNode();
            temp = res;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                if (l1 != null) {
                    carry += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    carry += l2.val;
                    l2 = l2.next;
                }
                temp.next = new ListNode(carry % 10);
                carry /= 10;
                temp = temp.next;

            }
            return res.next;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}