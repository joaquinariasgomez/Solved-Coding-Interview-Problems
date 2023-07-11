public class DeleteMiddleNodeOfLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void printLinkedList(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val+" -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void removeMiddleNode(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now remove slow node
        if(slow == head) {
            head = head.next;
        }
        else {
            prev.next = slow.next;
        }
    }

    public void run() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        printLinkedList(list);
        removeMiddleNode(list);
        printLinkedList(list);
    }

    public static void main(String[] args) {
        new DeleteMiddleNodeOfLinkedList().run();
    }
}