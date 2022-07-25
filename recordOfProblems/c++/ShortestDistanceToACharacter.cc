vector<int> shortestToChar(string s, char c) {
    std::vector<int> sol(s.size());
    int lastSeen = INT_MIN/2;
    
    for(int i=0; i<s.size(); i++) {
        if(s[i] == c) {
            lastSeen = i;
        }
        sol[i] = abs(i - lastSeen);
    }
    
    for(int i=s.size()-1; i>=0; i--) {
        if(s[i] == c) {
            lastSeen = i;
        }
        sol[i] = std::min(sol[i], abs(i - lastSeen));
    }
    
    return sol;
}

// O(N) time complexity
// O(N) space complexity, because you are building the "sol" of size N
