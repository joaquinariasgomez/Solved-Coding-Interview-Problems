import java.util.*;

public class FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> leftHeap;
        PriorityQueue<Integer> rightHeap;
        // Left heap (max heap) will always keep the greater element in the left half side of the array
        // Right heap (min heap) will always keep the smaller element in the right half side of the array

        public MedianFinder() {
            leftHeap = new PriorityQueue<Integer>((a, b) -> (b-a));
            rightHeap = new PriorityQueue<Integer>((a, b) -> (a-b));
        }
        
        public void addNum(int num) {
            if(leftHeap.isEmpty() && rightHeap.isEmpty()) {
                leftHeap.add(num);
            }
            else {
                if(num > leftHeap.peek()) {
                    rightHeap.add(num);
                }
                else {
                    leftHeap.add(num);
                }
            }

            // Check for uneven. At most difference must be one
            if(leftHeap.size() > rightHeap.size()+1) {  //Left is 2 bigger than right
                rightHeap.add(leftHeap.poll());
            }
            else if(rightHeap.size() > leftHeap.size()+1) {  //Right is 2 bigger than left
                leftHeap.add(rightHeap.poll());
            }
        }
        
        public double findMedian() {
            if(leftHeap.size() < rightHeap.size()) {
                return (double)rightHeap.peek();
            }
            else {
                if(leftHeap.size() > rightHeap.size()) {
                    return (double)leftHeap.peek();
                }
                else {
                    double value1 = (double)leftHeap.peek();
                    double value2 = (double)rightHeap.peek();
                    return (value1+value2)/2.;
                }
            }
        }
    }

    public void run() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
        // System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        // System.out.println(medianFinder.findMedian()); // return 2.0
    }
    public static void main(String[] args) {
        new FindMedianFromDataStream().run();
    }
}