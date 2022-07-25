int maxProfit(vector<int>& prices) {
    int min = INT_MAX;
    int max = 0;
    
    for(int i=0; i<prices.size(); i++) {
        if(prices[i] < min) {
            min = prices[i];
        }
        else {
            max = std::max(max, prices[i] - min);
        }
    }
    
    return max;
}
