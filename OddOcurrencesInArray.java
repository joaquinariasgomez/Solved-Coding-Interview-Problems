public class OddOcurrencesInArray {

    private int[] findRepeatedAndDelete(int[] list) {
        int element = list[0];
        boolean copyFound = false;

        int[] newList = new int[list.length - 2];
        int it2 = 0;

        int it = 1;
        do {
            if(list[it] == element && !copyFound) {
                copyFound = true;
            }
            else {
                if(it2<list.length - 2) {
                    newList[it2] = list[it];
                    ++it2;
                }
            }
            ++it;
        } while(it<list.length);
        
        if(!copyFound) {
            newList = new int[1];
            newList[0] = element;
        }
        return newList;
    }

    private void printList(int[] list) {
        for(Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }

    private void run() {
        int[] list = {9, 3, 9, 3, 9, 7, 9};
        //int[] list = {7, 9, 3, 9, 3, 9, 9};
        printList(list);

        int[] newList = list;
        do {
            newList = findRepeatedAndDelete(newList);
            printList(newList);
        } while(newList.length > 1);
        System.out.println("VICTORIA: "+newList[0]);
    }

    public static void main(String[] args) {
        new OddOcurrencesInArray().run();
    }
}
