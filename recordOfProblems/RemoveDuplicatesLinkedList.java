import java.util.HashSet;

public class RemoveDuplicatesLinkedList {

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

    public ListNode removeDuplicates(ListNode head) {
        if(head == null) return head;
        HashSet set = new HashSet<Integer>();
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(set.contains(curr.val)) {
                // Delete this value. It cannot be head
                prev.next = curr.next;
            }
            else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public void run() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(2);
        list.next.next.next.next.next = new ListNode(2);
        printLinkedList(list);
        list = removeDuplicates(list);
        printLinkedList(list);
    }
    public static void main(String[] args) {
        new RemoveDuplicatesLinkedList().run();
    }
}