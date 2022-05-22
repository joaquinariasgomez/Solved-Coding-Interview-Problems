import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ComponentsInAGraph {

    public class UnionFind {
        public UnionFind(int N) {
            id = new int[N];
            for(int i=0; i<N; i++) id[i] = i;
        }
        public boolean connected(int p, int q) {return id[p]==id[q];}
        public void union(int p, int q) {
            int pid = id[p];
            int qid = id[q];

            for(int i=0; i<id.length; i++) {
                if(id[i] == pid) id[i] = qid;
            }
        }
        public void printInternalData() {
            for(int i=0; i<id.length; i++) {
                System.out.print(id[i]+" ");
            }
            System.out.println();
        }
        public int[] getInternalData() {return id;}

        private int[] id;
    }

    public class UnionFindQuickUnion {
        public UnionFindQuickUnion(int N) {
            id = new int[N];
            for(int i=0; i<N; i++) id[i] = i;
        }
        private int root(int i) {
            while(i!=id[i]) i=id[i];
            return i;
        }
        public boolean connected(int p, int q) {return root(p)==root(q);}
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);

            id[i] = j;
        }
        public void printInternalData() {
            for(int i=0; i<id.length; i++) {
                System.out.print(id[i]+" ");
            }
            System.out.println();
        }

        private int[] id;
    } 

    public List<Integer> componentsInGraph(List<List<Integer>> gb) {
        int nNodes = 0;
        for(List<Integer> edge : gb) {
            nNodes = Math.max(nNodes, edge.get(0));
            nNodes = Math.max(nNodes, edge.get(1));
        }
        UnionFind uf = new UnionFind(nNodes);
        for(List<Integer> edge : gb) {
            uf.union(edge.get(0)-1, edge.get(1)-1);
        }
        int[] ufData = uf.getInternalData();
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int i=0; i<ufData.length; i++) {
            freqMap.put(ufData[i], freqMap.getOrDefault(ufData[i], 0)+1);
        }
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;
        for(HashMap.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue()>1) {
                maxFreq = Math.max(maxFreq, entry.getValue());
                minFreq = Math.min(minFreq, entry.getValue());
            }
        }
        return Arrays.asList(minFreq, maxFreq);
    }

    public void run() {
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 5),
                                                  Arrays.asList(2, 7),
                                                  Arrays.asList(1, 6),
                                                  Arrays.asList(4, 6));
        List<Integer> result = componentsInGraph(edges);
        System.out.println(result);
    }
    public static void main(String[] args) {
        new ComponentsInAGraph().run();
    }
}
