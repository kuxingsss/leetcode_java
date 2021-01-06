//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 331 👎 0

package leetcode.editor.cn;

//Java：分隔链表
public class P86PartitionList {
  public static void main(String[] args) {
    Solution solution = new P86PartitionList().new Solution();
    // TO TEST
    System.out.println();
  }
  //leetcode submit region begin(Prohibit modification and deletion)

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   * int val;
   * ListNode next;
   * ListNode(int x) { val = x; }
   * }
   */
  class Solution {
    public ListNode partition(ListNode head, int x) {
      if (head == null || head.next == null) return head;
      ListNode small = new ListNode(0);
      ListNode large = new ListNode(0);
      ListNode smallHead = small, largeHead = large;

      while (head != null) {
        if (head.val < x) {
          small.next = head;
          small = small.next;
        } else {
          large.next = head;
          large = large.next;
        }
        head = head.next;
      }
      large.next = null;
      small.next = largeHead.next;
      return smallHead.next;
    }
  }

  //leetcode submit region end(Prohibit modification and deletion)
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}