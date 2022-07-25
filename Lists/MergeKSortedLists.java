public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {next=null;}
        ListNode(int val) {this.val=val; next = null;}
    }

    public ListNode sortList(ListNode[] lists) {
        ListNode result = new ListNode(-309);
        ListNode head = result;
        int k = lists.length;

        int minIndex = -1;
        boolean allNull = false;
        while(!allNull) {
            int min = Integer.MAX_VALUE;
            allNull = true;
            for(int i=0; i<k; i++) {
                if(lists[i]!=null) {
                    allNull = false;
                    if(lists[i].val < min) {
                        min = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            if(!allNull) {
                lists[minIndex] = lists[minIndex].next;
                if(result.val == -309) {
                    result.val = min;
                }
                else {
                    ListNode newNode = new ListNode(min);
                    result.next = newNode;
                    result = newNode;
                }
            }
        }
        
        return head;
    }

    public void run() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode result = sortList(lists);
        ListNode current = result;
        while(current != null) {
            System.out.print(current.val+"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        new MergeKSortedLists().run();
    }
}
