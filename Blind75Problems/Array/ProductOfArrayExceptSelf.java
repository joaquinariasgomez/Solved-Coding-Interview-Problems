public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] sol = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            sol[i] = 1;
        }
        int prefix = 1;
        int postfix = 1;

        for(int i=0; i<nums.length; i++) {
            sol[i] = prefix;
            prefix *= nums[i];
        }

        for(int i=nums.length-1; i>=0; i--) {
            sol[i] *= postfix;
            postfix *= nums[i];
        }

        return sol;
    }

    public void run() {
        int[] nums = {1, 2, 3, 4};  // The product of an index will be equal to the product of every element before that index DOT the product of every other element after that index
        int[] sol = productExceptSelf(nums);
        for (int a: sol) {
            System.out.print(" "+a);
        }
    }
    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().run();
    }
}