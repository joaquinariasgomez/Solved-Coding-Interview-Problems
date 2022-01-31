ListNode* deleteMiddle(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    ListNode* prev = nullptr;
    
    while(fast != nullptr && fast->next != nullptr) {
        prev = slow;
        slow = slow->next;
        fast = fast->next->next;
    }
    // Now "slow" is the node to be deleted
    if(slow == head) {
        head = head->next;
    }
    else {
        prev->next = slow->next;
    }
    return head;
}
