public class DoublyLinkedList {

    class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class DoublyLinked {
        ListNode head;
        ListNode tail;

        public DoublyLinked() {
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        public void insertAtTail(ListNode node) {
            ListNode prevNode = tail.prev;
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = prevNode;
        }

        public void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void printFromHead() {
            ListNode curr = head.next;
            while (curr != null && curr != tail) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }

        public void printFromTail() {
            ListNode curr = tail.prev;
            while (curr != null && curr != head) {
                System.out.print(curr.val + " -> ");
                curr = curr.prev;
            }
            System.out.println("null");
        }
    }

    public void run() {
        DoublyLinked list = new DoublyLinked();
        list.insertAtTail(new ListNode(1));
        list.insertAtTail(new ListNode(2));
        list.insertAtTail(new ListNode(3));
        list.printFromHead();
        list.printFromTail();
    }

    public static void main(String[] args) {
        new DoublyLinkedList().run();
    }
}