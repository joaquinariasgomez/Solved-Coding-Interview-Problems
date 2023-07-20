import java.util.Arrays;

public class MergeKSortedLists {
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

    public ListNode merge(ListNode[] lists) {
        ListNode sol = new ListNode(-1);
        ListNode solHead = sol;
        boolean areElements = true;

        while(areElements) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            areElements = false;
            // Get the min element of all lists, that is not null, and append it to sol
            for(int i=0; i<lists.length; i++) {
                if(lists[i] != null) {
                    areElements = true;
                    if(lists[i].val <= min) {
                        min = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            if(areElements) {
                sol.next = new ListNode(lists[minIndex].val);
                sol = sol.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }

        return solHead.next;
    }

    public void run() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{list1, list2, list3};
        for(ListNode list : lists) {
            printList(list);
        }
        ListNode sol = merge(lists);
        printList(sol);
    }

    public static void main(String[] args) {
        new MergeKSortedLists().run();
    }
}