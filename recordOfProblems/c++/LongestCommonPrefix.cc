string longestCommonPrefix(vector<string>& strs) {
    std::string longest = strs[0];
    
    for(int i=1; i<strs.size(); i++) {
        int j = 0;
        while(j < strs[i].size() && strs[i][j] == longest[j]) {
            ++j;
        }
        longest = longest.substr(0, j);
    }
    
    return longest;
}

// O(N) time complexity, where 'N' is the sum of all characters of all strings
// O(1) space complexity, because we are not using extra space
