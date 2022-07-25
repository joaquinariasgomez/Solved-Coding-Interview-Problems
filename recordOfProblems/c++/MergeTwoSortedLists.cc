ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
    ListNode* sol = new ListNode(0);
    ListNode* curr = sol;
    
    while(list1 != nullptr || list2 != nullptr) {
        ListNode* next;
        if(list1 == nullptr) {
            next = new ListNode(list2->val);
            list2 = list2->next;
        }
        else {
            if(list2 == nullptr) {
                next = new ListNode(list1->val);
                list1 = list1->next;
            }
            else {
                if(list1->val < list2->val) {
                    next = new ListNode(list1->val);
                    list1 = list1->next;
                }
                else {
                    next = new ListNode(list2->val);
                    list2 = list2->next;
                }
            }
        }
        curr->next = next;
        curr = curr->next;
    }
    
    return sol->next;
}
