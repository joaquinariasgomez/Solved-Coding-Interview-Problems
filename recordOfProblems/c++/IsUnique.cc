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

int main() {
    std::string input = "holaa";
    std::cout << (hasUniqueChars(input) ? "Has unique chars" : "Has NOT unique chars") << std::endl;
}
