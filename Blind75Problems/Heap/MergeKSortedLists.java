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
        ListNode curr = new ListNode(-1);
        ListNode sol = curr;

        boolean areEmpty = false;
        while(!areEmpty) {
            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i=0; i<lists.length; i++) {
                if(lists[i] != null && lists[i].val < minValue) {
                    minValue = lists[i].val;
                    minIdx = i;
                }
            }
            if(minIdx != -1) {
                lists[minIdx] = lists[minIdx].next;
                curr.next = new ListNode(minValue);
                curr = curr.next;
            }
            else {
                areEmpty = true;
            }
        }
        return sol.next;
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