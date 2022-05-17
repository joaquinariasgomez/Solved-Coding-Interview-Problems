public static void plusMinus(List<Integer> arr) {
    int nPos = 0;
    int nNeg = 0;
    int nZero = 0;

    for(int i=0; i<arr.size(); i++) {
        if(arr.get(i) == 0) {
            nZero++;
        }
        else if(arr.get(i) > 0 ){
            nPos++;
        }
        else {
            nNeg++;
        }
    }
    
    System.out.println(new DecimalFormat("#.######").format((float)nPos/arr.size()));
    System.out.println(new DecimalFormat("#.######").format((float)nNeg/arr.size()));
    System.out.println(new DecimalFormat("#.######").format((float)nZero/arr.size()));
}
