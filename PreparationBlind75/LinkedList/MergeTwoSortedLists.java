public class MergeTwoSortedLists {
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
        while(curr != null) {
            System.out.print(curr.val+" -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode sol = new ListNode(-1);
        ListNode solHead = sol;

        while(curr1 != null || curr2 != null) {
            if(curr1 == null) {
                sol.next = new ListNode(curr2.val);
                curr2 = curr2.next;
                sol = sol.next;
            }
            else if(curr2 == null) {
                sol.next = new ListNode(curr1.val);
                curr1 = curr1.next;
                sol = sol.next;
            } else if(curr1.val <= curr2.val) {
                sol.next = new ListNode(curr1.val);
                curr1 = curr1.next;
                sol = sol.next;
            }
            else {
                sol.next = new ListNode(curr2.val);
                curr2 = curr2.next;
                sol = sol.next;
            }
        }
        return solHead.next;
    }

    public void run() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode mergedList = merge(list1, list2);
        printList(mergedList);
    }

    public static void main(String[] args) {
        new MergeTwoSortedLists().run();
    }
}