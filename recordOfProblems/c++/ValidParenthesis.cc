bool areOpposite(char a, char b) {
    switch(a) {
        case '(': return b == ')'; break;
        case '{': return b == '}'; break;
        case '[': return b == ']'; break;
        default: return false;
    }
    return false;
}

bool isValid(string s) {
    std::stack<char> stack;
    
    for(int i=0; i<s.length(); i++) {
        if(!stack.empty()) {
            char topChar = stack.top();
            if(areOpposite(topChar, s[i])) {
                stack.pop();
            }
            else {
                stack.push(s[i]);
            }
        }
        else {
            stack.push(s[i]);
        }
    }
    
    return stack.empty();
}
