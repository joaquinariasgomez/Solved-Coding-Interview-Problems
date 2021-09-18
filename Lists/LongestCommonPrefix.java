public class LongestCommonPrefix {
    if(strs == null || strs.length == 0) return "";
        
        String longest = strs[0];
        for(int i=1; i<strs.length; i++) {
            while(strs[i].indexOf(longest) != 0) {
                longest = longest.substring(0, longest.length()-1);
            }
        }
        return longest;
}
