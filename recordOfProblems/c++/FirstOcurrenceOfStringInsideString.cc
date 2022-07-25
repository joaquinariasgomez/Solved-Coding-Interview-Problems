#include<iostream>
#include<string>

int findIndex(std::string phrase, std::string word) {
    int index = -1;
    if(word.size() > phrase.size()) return index;
    if(phrase == word) return 0;

    for(int i=0; i<phrase.size(); i++) {
        bool match = true;
        int a = i;
        for(int j=0; j<word.size(); j++) {
            std::cout << "comparando " << phrase[a] << " con " << word[j] << std::endl;
            if(a >= phrase.size() || phrase[a++] != word[j]) {
                match = false;
            }
        }

        if(match) {
            index = a;
            break;
        }
    }

    return index;
}

int main() {
    std::string findHere = "hello";
    std::string word = "ll";
    std::cout << "Index of " << word << ": " << findIndex(findHere, word) << std::endl;
}

// O(N*M) time complexity, where N is the size of 'phrase' and 'M' is the size of word. This is a slow algorithm (brute force approach).
// O(1) space complexity, since we are not using any additional data structures.