public class MergeOrder {

    public void mergeVectors(int[] a, int[] b) {
        int i = a.length - b.length - 1;
        int j = b.length - 1;

        for(int k=a.length-1; k>=0; k--) {
            if(i<0) {
                a[k] = b[j--];
            }
            else if(j<0) {
                a[k] = a[i--];
            }
            else if(a[i] > b[j]) {
                a[k] = a[i--];
            }
            else {
                a[k] = b[j--];
            }
        }
    }

    public void run() {
        int[] a = {2, 4, 6, 6, 9, 0, 0, 0};
        int[] b = {1, 2, 10};
        mergeVectors(a, b);
        for(int e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new MergeOrder().run();
    }
}
