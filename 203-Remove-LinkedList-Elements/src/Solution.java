/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //method1
        /*while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return null;

        ListNode prev = head;*/

        //method2
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead.next;

        //删除节点
        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        //为什么是head啊 想不清楚
        return head;
    }
}