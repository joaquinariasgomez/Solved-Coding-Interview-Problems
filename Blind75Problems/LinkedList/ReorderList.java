public class ReorderList {
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

    public ListNode reorder(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode prev = mid;
        ListNode curr = mid.next;
        mid.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = head;
        ListNode sol = new ListNode(-1);
        ListNode solHead = sol;

        while(curr != null) {
            if(curr != prev) {
                sol.next = new ListNode(curr.val);
                sol = sol.next;
            }
            sol.next = new ListNode(prev.val);
            sol = sol.next;
            curr = curr.next;
            prev = prev.next;
        }

        return solHead.next;
    }

    public void reorderInPlace(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode prev = mid;
        ListNode curr = mid.next;
        mid.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // At this point, we have half of the list reversed and mid node pointing to null

        curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            curr = next;
            if(curr == prev) {
                prev.next = null;
            }
            else {
                ListNode prevNext = prev.next;
                prev.next = curr;
                prev = prevNext;
            }
        }
    }

    public void run() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        printList(list);
        // printList(reorder(list));
        reorderInPlace(list);
        printList(list);
    }
    public static void main(String[] args) {
        new ReorderList().run();
    }
}