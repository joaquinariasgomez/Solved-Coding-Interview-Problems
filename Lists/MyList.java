class Node {
  public int data;
  public Node next;
  public Node() {
    this.next = null;
  }
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

  public Node deleteNode(Node head, int e) {
    Node current = head;
    Node prev = null;
    while(current != null) {
      if(current.data == e) {
        if(current == head) {
          head = head.next;
        }
        else {
          prev.next = current.next;
        }
      }
      prev = current;
      current = current.next;
    }
    return head;
  }

  public Node reverseList(Node head) {
    Node current = head;
    Node prev = null;
    while(current != null) {
      Node nextNode = current.next;
      current.next = prev;
      prev = current;
      current = nextNode;
    }
    return prev;
  } 

  public void printNode(Node head) {
    Node current = head;
    while(current != null) {
      System.out.print(current.data+"->");
      current = current.next;
    }
    System.out.println("null");
  }

  public void run() {
    Node node = new Node();
    node = new Node(1);
    node.next = new Node(2);
    node.next.next = new Node(3);
    node.next.next.next = new Node(4);
    printNode(node);
    Node result = deleteNode(node, 4);
    printNode(result);
    printNode(reverseList(result));
  }
  public static void main(String[] args) {
    new MyList().run();
  }
}
