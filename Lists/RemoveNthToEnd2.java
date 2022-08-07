class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = head;
        
        for(int i=0; i<n; i++) {
            p2 = p2.next;
        }
        
        while(p2 != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }  
        // At this point, p1 is at the position we want to remove
        if(p1 == head) {
            return p1.next;
        }
        prev.next = p1.next;
        return head;
    }
}
