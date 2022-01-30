#include<iostream>
#include<vector>
#include<queue>

int findKthLargest(std::vector<int>& nums, int k) {
    std::priority_queue<int> maxHeap;
    
    for(int i=0; i<nums.size(); i++) {
        maxHeap.push(nums[i]);
    }
    
    for(int i=0; i<k-1; i++) {
        maxHeap.pop();
    }
    
    return maxHeap.top();
}

int main() {
    std::vector<int> elements = {3,2,1,5,6,4};

    std::cout << findKthLargest(elements, 2) << std::endl;
}
