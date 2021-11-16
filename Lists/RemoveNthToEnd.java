public class RemoveNthToEnd {
    class ListNode {
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val+" -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode removeNodes(ListNode head, int n) {
        if(n==0) return null;
        ListNode current = head;
        for(int i=1; i<n; i++) {
            current = current.next;
        }
        if(current == null) return head;
        current.next = null;
        return head;
    }

    public void run() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        printList(list);
        ListNode newList = removeNodes(list, 2);
        printList(newList);
    }

    public static void main(String[] args) {
        new RemoveNthToEnd().run();
    }
}
