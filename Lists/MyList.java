class Node {
  public int data;
  public Node next;
  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  public Node head;
  
  public LinkedList() {head = null;}

  public void insert(int elem, int pos) {
    //TODO
  }

  public void reverse() {
    Node current = head;
    Node prev = null;
    while(current != null) {
      Node next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }

  public void deleteNode(int key) {
    Node prev = null;
    Node current = head;
    
    while(current != null) {
      if(current.data == key) { // Delete current
        if(current == head) { // Delete first element
          head = head.next;
          current = head;
        }
        else {
          prev.next = current.next;
          current = current.next;
        }
      }
      else {
        prev = current;
        current = current.next;
      }
    }
  }

  public boolean isEmpty() {return this.head == null;}
  public void print() {
    Node current = head;
    while(current != null) {
      System.out.print(current.data+"->");
      current = current.next;
    }
    System.out.println("null");
  }
}

public class MyList {
  public void run() {
    LinkedList l = new LinkedList();
    l.head = new Node(1);
    l.head.next = new Node(2);
    l.head.next.next = new Node(3);
    l.print();
    l.reverse();
    l.print();
    l.deleteNode(2);
    l.print();
  }
  public static void main(String[] args) {
    new MyList().run();
  }
}
