package inplace_reversal_of_linkedlist;

public class ReverseEveryKElementSubList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode reverse(ListNode head, int k) {
        if (k <= 1 && head == null)
            return head;
        ListNode curr = head, previous = null, next = null;
        while (true) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = curr;
            for (int idx = 0; curr != null && idx < k; idx++) {
                next = curr.next;
                curr.next = previous;
                previous = curr;
                curr = next;
            }
            if (lastNodeOfPreviousPart != null)
                lastNodeOfPreviousPart.next = previous;
            else
                head = previous;
            lastNodeOfSubList.next = curr;
            if (curr == null)
                break;
            previous = lastNodeOfSubList;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode result = reverse(head, 3);
        while (result!=null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
