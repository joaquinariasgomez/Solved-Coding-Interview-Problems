import java.util.HashMap;

public class FruitIntoBaskets {

    public int maxFruits(int[] fruits) {
        int begin = 0;
        int end = 0;
        int max = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<Integer, Integer>();
        while(end < fruits.length) {
            System.out.println("We are at "+begin+" and "+end);
            if(fruitCount.size() < 2 || fruitCount.containsKey(fruits[end])) {
                System.out.println("Podemos meter fruta");
                fruitCount.put(fruits[end], fruitCount.getOrDefault(fruits[end], 0)+1);
                max = Math.max(max, end-begin+1);
                end++;
            }
            else {
                System.out.println("NO podemos meter fruta");
                fruitCount.remove(fruits[begin++]);
            }
        }
        return max;
    }

    public void run() {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(maxFruits(fruits));
    }
    public static void main(String[] args) {
        new FruitIntoBaskets().run();
    }
}