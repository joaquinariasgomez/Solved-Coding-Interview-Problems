public class HurdleRace {
    int maxHeight = Integer.MIN_VALUE;        
    for(int i=0; i<height.size(); i++) {
        maxHeight = Math.max(maxHeight, height.get(i));
    }
    if(k>maxHeight) return 0;
    else {
        return maxHeight-k;
    }
}
