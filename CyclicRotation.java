import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

class CyclicRotation {

    private int[] rotateList(int[] list) {
        int[] newList = new int[list.length];

        newList[0] = list[list.length - 1];
        for(int i = 0; i<list.length - 1; ++i) {
            newList[i+1] = list[i];
        }

        return newList;
    }

    private void run() {
        int[] list = {3, 8, 9, 7, 6};

        int[] list2 = rotateList(list);

        for(Integer integer : list2) {
            System.out.print(integer+" ");
        }
    }

    public static void main(String[] args) {
        new CyclicRotation().run();
    }
}