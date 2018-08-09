/**
 * 递归的方式进行解决
 */
public class SolutionR {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new SolutionR()).removeElements(head, 6);
        System.out.println(res);
    }
}
