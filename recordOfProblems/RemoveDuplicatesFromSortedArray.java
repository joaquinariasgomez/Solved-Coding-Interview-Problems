public class RemoveDuplicatesFromSortedArray {

    public int getNOfUniqueElements(int[] input) {
        int j=0;
        if(input.length == 0) return 0;

        for(int i=0; i<input.length-1; i++) {
            if(input[i] != input[i+1]) {
                input[j++] = input[i];
            }
        }

        input[j++] = input[input.length-1];
        return j;
    }

    public void run() {
        int[] input = {1,1,1,2,2,10,11};
        int nOfElements = getNOfUniqueElements(input);
        for(int i=0; i<nOfElements; i++) {
            System.out.print(input[i]+" ");
        }
    }
    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArray().run();
    }
}