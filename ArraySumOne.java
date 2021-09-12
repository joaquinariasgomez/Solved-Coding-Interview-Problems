public class ArraySumOne {

    public int[] addOne(int[] number) {
        if(number == null || number.length == 0) return number;
        int[] solution = new int[number.length];
        boolean carried = false;

        for(int i=number.length-1; i>=0; i--) {
            if(i==number.length-1 || carried) {
                if((number[i]+1)%10==0) {
                    solution[i] = 0;
                    carried = true;
                }
                else {
                    solution[i] = number[i]+1;
                    carried = false;
                }
            }
            else {
                solution[i] = number[i];
            } 
        }
        if(carried) {
            solution = new int[number.length+1];
            solution[0] = 1;
        }
        return solution;
    }

    public void run() {
        int[] number = {3,9};
        int[] solution = addOne(number);
        for(int e : solution) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new ArraySumOne().run();
    }
}
