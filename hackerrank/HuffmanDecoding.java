public class HuffmanDecoding {
    class Node {
        public Node(char data, int freq) {
            this.data = data;
            this.frecuency = freq;
        }

        char data;
        Node left;
        Node right;
        int frecuency;
    }

    public boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    void decode(String s, Node root) {
        char[] input = s.toCharArray();
        Node current = root;
        if(current == null) return;
        if(isLeaf(current)) {
            System.out.print(current.data); return;
        }
        
        for(int i=0; i<input.length; i++) {
            if(input[i] == '0') {
                current = current.left;
            }
            else {
                current = current.right;
            }
            if(isLeaf(current)) {
                System.out.print(current.data);
                current = root;
            }
        }
    }

    public void run() {
        String s = "1001011";
        Node root = new Node('%', 5);
        root.left = new Node('%', 2);
        root.right = new Node('A', 3);
        root.left.left = new Node('B', 1);
        root.left.right = new Node('C', 1);
        decode(s, root);
    }
    public static void main(String[] args) {
        new HuffmanDecoding().run();
    }
}
