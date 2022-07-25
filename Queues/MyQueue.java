class Queue {
  private class Node {
    public String item;
    public Node next;
    public Node(String i) {item = i;}
  }

  private Node top;

  public Queue() {
    top = null;
  }

  public void push(String item) {
    Node topNode = top;
    top = new Node(item);
    top.next = topNode;
  }

  public String pop() {
    if(!isEmpty()) {
      String element = top.item;
      top = top.next;
      return element;
    }
    else {
      return "Cannot pop, its empty";
    }
  }

  public boolean isEmpty() {
    return top == null;
  }
}

public class MyQueue {
  public static void main(String[] args) {
    Queue s = new Queue();
    s.push("Me");
    s.push("Llamo");
    s.push("Joaquín");
    System.out.println(s.pop());
  }
}