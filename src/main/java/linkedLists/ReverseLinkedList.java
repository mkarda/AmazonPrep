package linkedLists;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode = reverseList(l);

        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
