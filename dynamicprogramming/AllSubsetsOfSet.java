import java.util.ArrayList;

public class AllSubsetsOfSet {

    public ArrayList<Integer> intToSubset(int i, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int k=i; k>0; k=k>>1) {
            if((k&1)==1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size();
        for(int i=0; i<max; i++) {
            ArrayList<Integer> subset = intToSubset(i, set);    //Select items from set depending on int "i"
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    public void printSubsets(ArrayList<ArrayList<Integer>> subsets) {
        for(ArrayList<Integer> subset : subsets) {
            for(int e : subset) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public void run() {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        ArrayList<ArrayList<Integer>> subsets = getSubsets(set);
        printSubsets(subsets);
    }
    public static void main(String[] args) {
        new AllSubsetsOfSet().run();
    }
}