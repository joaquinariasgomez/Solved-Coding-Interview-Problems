public class RemoveNthNodeFromEnd {
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
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public ListNode removeElement(ListNode head, int n) {
        ListNode curr = head;
        for(int i=0; i<n; i++) {
            curr = curr.next;
        }
        ListNode begin = head;
        ListNode prev = null;
        while(curr != null) {
            prev = begin;
            curr = curr.next;
            begin = begin.next;
        }
        // Now, remove begin
        if(begin == head) return head.next;
        prev.next = begin.next;
        return head;
    }

    public void run() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        printList(list);
        printList(removeElement(list, 2));
    }
    public static void main(String[] args) {
        new RemoveNthNodeFromEnd().run();
    }
}