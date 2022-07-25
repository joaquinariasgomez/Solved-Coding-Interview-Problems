/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int beg = 1;
        int end = n;
        
        while(beg < end)  {
            int mid = beg + (end-beg)/2;
            boolean isBad = isBadVersion(mid);
            if(!isBad) {
                beg = mid+1;
            }
            else {
                end = mid;
            }
        }
        
        return end;
    }
}
