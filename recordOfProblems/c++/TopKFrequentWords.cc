class Comparator {
    public:
        bool operator() (std::pair<std::string, int> wordInfo1, std::pair<std::string, int> wordInfo2)  {
            if(wordInfo1.second == wordInfo2.second) { // Same word frequency
                return wordInfo1.first > wordInfo2.first;
            }
            else {
                return wordInfo1.second < wordInfo2.second;   
            }
        }
};

class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        // First, we create a frequent map to sort afterwards
        std::map<std::string, int> map;
        std::priority_queue<std::pair<std::string, int>, std::vector<std::pair<std::string, int>>, Comparator> maxHeap;
        std::vector<std::string> sol;
        
        for(int i=0; i<words.size(); i++) {
            if(map.find(words[i]) == map.end()) {
                map[words[i]] = 0;
            }
            else {
                map[words[i]]++;
            }
        }
        
        std::map<std::string, int>::iterator it = map.begin();
        while(it != map.end()) {
            maxHeap.push(std::make_pair(it->first, it->second));
            ++it;
        }
        
        for(int i=0; i<k; i++) {
            sol.push_back(maxHeap.top().first);
            maxHeap.pop();
        }
        
        return sol;
    }
};
