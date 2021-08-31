import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

class IntegerToBinary {

    private List<Integer> decimalToBinary(Integer decimal) {
        List<Integer> binaries = new ArrayList<Integer>();
        
        while(decimal >= 2) {
            Integer resto = decimal%2;
            decimal = decimal/2;
            binaries.add(resto);
        }
        binaries.add(1);
        return binaries;
    }

    private int binaryGap(List<Integer> binary) {
        int zerosCount = 0;

        if(binary.size() == 1) {return 0;}

        int firstOneIndex = binary.indexOf(1);
        List<Integer> secondSubList = new ArrayList<Integer>();
        if(firstOneIndex != -1) {
            List<Integer> subList = binary.subList(firstOneIndex+1, binary.size());
            int secondOneIndex = subList.indexOf(1);
            if(secondOneIndex != -1) {
                zerosCount = secondOneIndex;
                secondSubList = subList.subList(secondOneIndex, subList.size());
            }
            else {
                return 0;
            }
        }
        return Math.max(zerosCount, binaryGap(secondSubList));
    }

    private void run() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input a number: ");
        Integer number = keyboard.nextInt();

        List<Integer> binaries = decimalToBinary(number);
        for (Integer integer : binaries) {
            System.out.print(integer);
        }
        System.out.println("\nBinary gap: "+this.binaryGap(binaries));
    }

    public static void main(String[] args) {
        new IntegerToBinary().run();
    }
}