int lengthOfLongestSubstring(string s) {
    std::unordered_set<char> set;
    int begin = 0;
    int end = 0;
    int maxLength = 0;
    
    while(end < s.size()) {
        if(set.find(s[end]) == set.end()) {
            set.insert(s[end++]);
            maxLength = std::max(maxLength, (int)set.size());
        }
        else {
            set.erase(s[begin++]);
        }
    }
    
    return maxLength;
}
