bool isPalindrome(string s) {
    int begin = 0;
    int end = s.length() - 1;
    
    while(begin < end) {
        if(!std::isalnum(s[begin])) {
            begin++;
        }
        else if(!std::isalnum(s[end])) {
            end--;
        }
        else {
            if(std::tolower(s[begin]) != std::tolower(s[end])) {
                return false;
            }
            begin++;
            end--;
        }
        
    }
    
    return true;
}
