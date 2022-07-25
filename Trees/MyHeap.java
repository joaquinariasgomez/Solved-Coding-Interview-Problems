class Heap {
  private int maxNodes;
  private int lastNode;
  private int[] nodes;

  private int father(int node) {return (node-1)/2;}
  private int leftChild(int node) {return node * 2 + 1;}
  private int rightChild(int node) {return node *2 + 2;}
  private void flotar(int node) {
    int e = nodes[node];
    while(node > 0 && e < nodes[father(node)]) {
      nodes[node] = nodes[father(node)];
      node = father(node);
    }
    nodes[node] = e;
  }
  private void sink(int node) {
    boolean end = false;
    int e = nodes[node];
    while(leftChild(node) <= lastNode && !end) {
      int hMin;
      if(leftChild(node) < lastNode && nodes[rightChild(node)] < nodes[leftChild(node)]) {
        hMin = rightChild(node);
      }
      else {
        hMin = leftChild(node);
      }
      if(nodes[hMin] < e) {
        nodes[node] = nodes[hMin];
        node = hMin;
      }
      else {
        end = true;
      }
    }
    nodes[node] = e;
  }

  public Heap(int maxNodes) {
    this.maxNodes = maxNodes;
    this.lastNode = -1;
    nodes = new int[maxNodes];
  }
  public void insert(int e) {
    nodes[++lastNode] = e;
    if(lastNode > 0) {  // Más de un elemento en el árbol
      this.flotar(lastNode);
    }
  }
  public void delete() {
    if((lastNode-1) >= 0) { // Árbol no queda vacío
      nodes[0] = nodes[lastNode--];
      if(lastNode > 0) {
        sink(0);
      }
    }
  }
  public int top() {return nodes[0];}
  public boolean isEmpty() {return lastNode == -1;}
  public void print() {
    for(int i=0; i<maxNodes; i++) {
      System.out.print(nodes[i]+" ");
    }
    System.out.println();
  }
}

public class MyHeap {

  public void run() {
    Heap t = new Heap(7);
    t.insert(10);
    t.insert(2);
    t.insert(8);
    t.print();
    t.insert(1);
    t.print();
  }
  public static void main(String[] args) {
    new MyHeap().run();
  }
}