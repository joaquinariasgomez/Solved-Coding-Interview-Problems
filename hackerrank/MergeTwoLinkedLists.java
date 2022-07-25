public class MergeTwoLinkedLists {
    class SinglyLinkedListNode {
        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
        SinglyLinkedListNode next;
        int data;
    }

    SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode sol = new SinglyLinkedListNode(200);
        SinglyLinkedListNode current = sol;
        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2 = head2;
        
        while(curr1 != null || curr2 != null) {
            // We need to get the minimum element
            int val1 = Integer.MAX_VALUE;
            int val2 = Integer.MAX_VALUE;
            if(curr1 != null) val1 = curr1.data;
            if(curr2 != null) val2 = curr2.data;
            if(val1 < val2) {
                current.next = new SinglyLinkedListNode(val1);
                curr1 = curr1.next;
            }
            else {
                current.next = new SinglyLinkedListNode(val2);
                curr2 = curr2.next;
            }
            current = current.next;
        }
        
        return sol.next;
    }
}
