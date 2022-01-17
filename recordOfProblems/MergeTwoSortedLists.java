public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode resultHead = result;
        ListNode current1 = list1;
        ListNode current2 = list2;
        
        while(current1 != null || current2 != null) {
            int val1 = 200;
            int val2 = 200;
            
            if(current1 != null) {
                val1 = current1.val;
            }
            if(current2 != null) {
                val2 = current2.val;
            }
            
            if(val1 < val2) {
                result.next = new ListNode(val1);
                current1 = current1.next;
            }
            else {
                result.next = new ListNode(val2);
                current2 = current2.next;
            }
            result = result.next;
        }
        
        return resultHead.next;
    }
}
