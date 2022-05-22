public class DeleteANode {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        SinglyLinkedListNode curr = llist;
        SinglyLinkedListNode prev = null;
        
        for(int i=0; i<position; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        if(curr == llist) {
            return llist.next;  // Remove head (first node)
        }
        else {
            prev.next = curr.next;
        }
        return llist;
    }
}
