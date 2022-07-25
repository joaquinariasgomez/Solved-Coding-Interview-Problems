vector<string> generateParenthesis(int n) {
    std::unordered_set<std::string> hashSet;    // HashSet to control duplicates
    return generateParenthesisChild(n, hashSet);
}

vector<string> generateParenthesisChild(int n, std::unordered_set<std::string> hashSet) {
    std::vector<std::string> sol;
    if(n==0) return sol;
    if(n==1) {
        sol.push_back("()");
    }
    else {
        std::vector<std::string> currentPars = generateParenthesisChild(n-1, hashSet);
        for(int i=0; i<currentPars.size(); i++) {
            //Add par at end
            std::string newPar = currentPars[i]+"()";
            if(hashSet.find(newPar) == hashSet.end()) {
                sol.push_back(newPar);
                hashSet.insert(newPar);
            }
            //Add par inside after every '('
            addInsideParenthesis(currentPars[i], hashSet, sol);
        }
    }
    return sol;
}

void addInsideParenthesis(std::string currentPar, std::unordered_set<std::string>& hashSet, std::vector<std::string>& sol) {
    for(int i=0; i<currentPar.size(); i++) {    // Analyzing the current parenthesis
        if(currentPar[i] == '(') {
            std::string start = currentPar.substr(0, i+1);
            std::string end = currentPar.substr(i+1);
            std::string newPar = start + "()" + end;
            if(hashSet.find(newPar) == hashSet.end()) {
                sol.push_back(newPar);
                hashSet.insert(newPar);
            }
        }
    }
}

// O(N) space complexity, because it is what it takes to store the solution "sol" and for the hashSet
// O(N) time complexity
