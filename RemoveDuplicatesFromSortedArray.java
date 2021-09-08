

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] array) {
        int j=0;

        for(int i=0; i<array.length-1; i++) {
            if(array[i] != array[i+1])
                array[j++] = array[i];
        }

        array[j++] = array[array.length-1];

        return j;
    }

    public void run() {
        int[] array = {1,1,1,2,2,10,11};
        System.out.println(removeDuplicates(array));
        for(int e : array) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArray().run();
    }
}
