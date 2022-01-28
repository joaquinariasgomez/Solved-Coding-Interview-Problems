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

    public ListNode removeNodesFromBeginning(ListNode head, int n) {
        if(n==0) return null;
        ListNode current = head;
        for(int i=1; i<=n-1; i++) {
            if(current != null) current = current.next;
        }
        if(current == null) return head;
        current.next = null;
        return head;
    }

    public ListNode removeNodesFromEnd(ListNode head, int n) {
        ListNode curr1 = head;
        ListNode prev = null;
        ListNode curr2 = head;

        for(int i=1; i<=n; i++) {
            if(curr2 != null) curr2 = curr2.next;
        }

        while(curr2 != null) {
            prev = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if(prev == null) return null;
        prev.next = null;
        return head;
    }

    public ListNode removeNode(ListNode head, int target) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            if(current.val == target) {
                if(current == head) {
                    return head.next;
                }
                else {
                    prev.next = current.next;
                }
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    public void run() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        printList(list);
        //ListNode newList = removeNodesFromBeginning(list, 3);
        //ListNode newList = removeNodesFromEnd(list, 1);
        ListNode newList = removeNode(list, 2);
        printList(newList);
    }

    public static void main(String[] args) {
        new RemoveNthToEnd().run();
    }
}
