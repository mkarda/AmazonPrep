package linkedLists;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(8, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);


        System.out.print(listNode.val);
        ListNode l = listNode;
        while (l.next != null) {
            l = l.next;
            System.out.print(l.val);
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode list1 = l1, list2 = l2, current = dummyHead;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int x = (list1 != null) ? list1.val : 0;
            int y = (list2 != null) ? list2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
