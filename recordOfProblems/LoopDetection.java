public class LoopDetection {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null) return null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return null;
        slow = head;
        while(slow != fast) {
            slow= slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void run() {
        ListNode list = new ListNode(3);
        ListNode cycle = new ListNode(2);
        list.next = cycle;
        cycle.next = new ListNode(0);
        cycle.next.next = new ListNode(-4);
        cycle.next.next.next = cycle;
        System.out.println(detectCycle(list).val);
    }
    public static void main(String[] args) {
        new LoopDetection().run();
    }
}