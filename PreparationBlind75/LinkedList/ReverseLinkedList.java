public class ReverseLinkedList {
    public class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public void printList(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val+" -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void run() {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(3);
        printList(list);
        printList(reverse(list));
    }
    public static void main(String[] args) {
        new ReverseLinkedList().run();
    }
}