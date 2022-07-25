ListNode* mergeKLists(vector<ListNode*>& lists) {
    ListNode* sol = new ListNode();
    ListNode* curr = sol;
    bool kListsEmpty = false;
    int k = lists.size();
    
    while(!kListsEmpty) {
        int minVal = INT_MAX;
        int minList = 0;
        
        kListsEmpty = true;
        for(int i=0; i<k; i++) { // Iterate through k heads
            if(lists[i] != nullptr) {
                kListsEmpty = false;
                if(lists[i]->val < minVal) {
                    minVal = lists[i]->val;
                    minList = i;
                }
            }
        }
        
        if(!kListsEmpty) {
            ListNode* next = new ListNode(minVal);
            curr->next = next;
            curr = curr->next;

            lists[minList] = lists[minList]->next;
        }
    }
    
    return sol->next;
}

// O(k*N) time, where N is the total number of nodes. Because for every element to be inserted, you are doing 'k' comparations to get the minimum element.
// O(N) space, where N is the total number of nodes, because you need to store the solution of size N
