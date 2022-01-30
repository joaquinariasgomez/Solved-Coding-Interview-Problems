#include<iostream>
#include<vector>
#include<queue>

int findKthLowest(std::vector<int>& nums, int k) {
    std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;

    for(int i=0; i<nums.size(); i++) {
        minHeap.push(nums[i]);
    }

    for(int i=0; i<k-1; i++) {
        minHeap.pop();
    }

    return minHeap.top();
}

int main() {
    std::vector<int> elements = {3,2,1,5,6,4};

    std::cout << findKthLowest(elements, 2) << std::endl;
}
