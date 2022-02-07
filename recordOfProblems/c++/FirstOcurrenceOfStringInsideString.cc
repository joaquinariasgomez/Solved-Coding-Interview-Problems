#include<iostream>
#include<string>

int findIndex(std::string phrase, std::string word) {
    int index = -1;

    for(int i=0; i<phrase.size(); i++) {
        bool match = true;
        for(int j=0; j<word.size(); j++) {
            if(phrase[i++] != word[j]) {
                match = false;
            }
        }

        if(match) {
            index = i;
        }
    }

    return index;
}

int main() {
    std::string findHere = "this is a test";
    std::string word = "test";
    std::cout << "Index of " << word << ": " << findIndex(findHere, word) << std::endl;
}

// O(N*M) time complexity, where N is the size of 'phrase' and 'M' is the size of word. This is a slow algorithm (brute force approach).
// O(1) space complexity, since we are not using any additional data structures.