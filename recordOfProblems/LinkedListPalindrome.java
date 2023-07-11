import java.util.ArrayList;

public class LinkedListPalindrome {
    class ListNode {
        char val;
        ListNode next;
        ListNode(char val) {
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

    // NOT EFFICIENT -> O(N) memory
    // public boolean isPalindrome(ListNode head) {
    //     ArrayList array = new ArrayList<Character>();
    //     ListNode curr = head;
    //     while(curr != null) {
    //         array.add(curr.val);
    //         curr = curr.next;
    //     }
    //     return isPalindrome(array);
    // }

    // public boolean isPalindrome(ArrayList<Character> array) {
    //     int pbegin = 0;
    //     int pend = array.size()-1;
    //     while(pbegin < pend) {
    //         if(array.get(pbegin) != array.get(pend)) return false;
    //         pbegin++;
    //         pend--;
    //     }
    //     return true;
    // }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Now reverse from slow to end
        prev.next = reverseList(slow);

        printLinkedList(head);

        ListNode beg1 = head;
        ListNode beg2 = prev.next;
        // System.out.println("Estoy en "+beg1.val+", "+beg2.val);
        while(beg1 != prev.next && beg2 != null) {
            if(beg1.val != beg2.val) return false;
            beg1 = beg1.next;
            beg2 = beg2.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
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
        ListNode list = new ListNode('a');
        list.next = new ListNode('b');
        list.next.next = new ListNode('c');
        list.next.next.next = new ListNode('b');
        list.next.next.next.next = new ListNode('a');
        printLinkedList(list);
        System.out.println(isPalindrome(list));
    }
    public static void main(String[] args) {
        new LinkedListPalindrome().run();
    }
}