public class HighestValuePalindrome {

    public String changeNumber(String input, int index) {
        String newString = input;
        String beginning = input.substring(0, index);
        String end = input.substring(index+1);
        newString = beginning+'9'+end;
        return newString;
    }

    public String getOutput(String input, int k, int n) {
        int begin = 0;
        int end = n-1;

        int minChanges = 0;
        while(begin < end) {
            if(input.charAt(begin) != input.charAt(end)) {
                minChanges++;
            }
            begin++;
            end--;
        }
        int extraChanges = k - minChanges;
        begin = 0;
        end = n-1;

        while(begin <= end) {
            if(extraChanges > 1) {
                if(Character.getNumericValue(input.charAt(begin)) < 9) {
                    input = changeNumber(input, begin);
                    extraChanges--;
                }
                if(Character.getNumericValue(input.charAt(end)) < 9) {
                    input = changeNumber(input, end);
                    extraChanges--;
                }
                begin++;
                end--;
            }
            else {
                if(extraChanges == 1) {
                    input = changeNumber(input, begin);
                    extraChanges--;
                    begin++;
                    end--;
                }
                else {
                    begin++;
                    end--;
                }
            }
        }

        return input;
    }

    public void run() {
        int k = 3;
        int n = 7;
        String input = "1234321";
        System.out.println(getOutput(input, k, n));
    }
    public static void main(String[] args) {
        new HighestValuePalindrome().run();
    }
}
