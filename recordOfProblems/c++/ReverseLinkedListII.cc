ListNode* reverseBetween(ListNode* head, int left, int right) {
    ListNode* curr = head;
    ListNode* prev = nullptr;
    
    for(int i=1; i<left; i++) {
        prev = curr;
        curr = curr->next;
    }
    
    ListNode* leftNode = prev;
    ListNode* rightNode = curr;
    
    int iterations = 0;
    while(iterations <= (right-left)) {
        ListNode* next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
        ++iterations;
    }
    
    if(leftNode != nullptr) {
        leftNode->next = prev;
    }
    else {
        head = prev;
    }
    
    rightNode->next = curr;
    return head;
}
