//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 846 👎 0

package leetcode.editor.cn;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.ArrayList;
import java.util.Comparator;

//Java：排序链表
public class P148SortList {
  public static void main(String[] args) {
    Solution solution = new P148SortList().new Solution();
    // TO TEST
    System.out.println();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode() {}
   * ListNode(int val) { this.val = val; }
   * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {
    public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode curNode = head;
      ArrayList<Integer> list = new ArrayList<>();
      while (curNode != null) {
        list.add(curNode.val);
        curNode = curNode.next;
      }
      list.sort(Comparator.naturalOrder());
      curNode = head;
      int i = 0;
      while (curNode != null) {
        curNode.val = list.get(i);
        curNode = curNode.next;
        i++;
      }
      return head;
    }
  }

  //leetcode submit region end(Prohibit modification and deletion)
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