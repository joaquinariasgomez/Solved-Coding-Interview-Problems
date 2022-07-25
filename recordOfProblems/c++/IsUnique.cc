#include <iostream>
#include <string>
#include <unordered_set>

bool hasUniqueChars(std::string input) {
    bool result = true;
    std::unordered_set<char> hashSet;

    for(int i=0; i<input.length(); i++) {
        if(hashSet.find(input[i]) != hashSet.end()) {
            return false;
        }
        hashSet.insert(input[i]);
    }
    return result;
}

bool hasUniqueChars2(std::string input) {
    bool result = true;
    bool charSet[128];

    for(int i=0; i<128; i++) {
        charSet[i] = false;
    } 

    for(int i=0; i<input.length(); i++) {
        if(charSet[input[i]]) {
            return false;
        }
        charSet[input[i]] = true;
    }
    return result;
}

int main() {
    std::string input = "holaa";
    std::cout << (hasUniqueChars2(input) ? "Has unique chars" : "Has NOT unique chars") << std::endl;
}
