import java.util.HashSet;

public class DetectCycleInALinkedList {

    public class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public boolean hasCycleSet(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode curr = head;
        while(curr != null) {
            if(set.contains(curr)) return true;
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public boolean hasCycleTortoise(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public void run() {
        ListNode list = new ListNode(3);
        ListNode collision = new ListNode(2);
        list.next = collision;
        collision.next = new ListNode(0);
        collision.next.next = new ListNode(-4);
        collision.next.next.next = collision;
        System.out.println(hasCycleTortoise(list));
    }
    public static void main(String[] args) {
        new DetectCycleInALinkedList().run();
    }
}