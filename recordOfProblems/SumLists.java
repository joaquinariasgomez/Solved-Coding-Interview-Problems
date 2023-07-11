public class SumLists {

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

    public ListNode getSum(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        if(curr1 == null) return curr2;
        if(curr2 == null) return curr1;
        ListNode sol = new ListNode(-1);
        ListNode solHead = sol;
        int carry = 0;

        while(curr1 != null || curr2 != null) {
            int sum = 0;
            if(curr1 != null && curr2 != null) {
                sum = curr1.val + curr2.val + carry;
                if(sum >= 10) {
                    sum = sum%10;
                    carry = 1;
                }
                else {
                    carry = 0;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            else {
                if(curr1 == null) {
                    sum = curr2.val + carry;
                    if(sum >= 10) {
                        sum = sum%10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                    curr2 = curr2.next;
                }
                else {
                    if(curr2 == null) {
                        sum = curr1.val + carry;
                        if(sum >= 10) {
                            sum = sum%10;
                            carry = 1;
                        }
                        else {
                            carry = 0;
                        }
                        curr1 = curr1.next;
                    }
                }
            }
            sol.next = new ListNode(sum);
            sol = sol.next;
        }
        if(carry != 0) {
            sol.next = new ListNode(carry);
        }
        return solHead.next;
    }

    public void run() {
        ListNode number1 = new ListNode(7);
        number1.next = new ListNode(1);
        number1.next.next = new ListNode(6);
        ListNode number2 = new ListNode(5);
        number2.next = new ListNode(9);
        number2.next.next = new ListNode(2);
        printLinkedList(number1);
        printLinkedList(number2);
        ListNode solution = getSum(number1, number2);
        printLinkedList(solution);
    }
    public static void main(String[] args) {
        new SumLists().run();
    }
}