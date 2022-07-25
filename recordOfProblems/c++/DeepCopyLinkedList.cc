#include <iostream>

class ListNode {
    public:
        int val;
        ListNode* next;
        ListNode* random;
        
        ListNode(int _val) {
            val = _val;
            next = nullptr;
            random = nullptr;
        }
};

void printList(ListNode* head) {
    ListNode* curr = head;
    while(curr != nullptr) {
        std::cout << curr->val << " -> ";
        curr = curr->next;
    }
    std::cout << "nullptr" << std::endl;
}

ListNode* createCopyOf(ListNode* head) {
    if(head == nullptr) return nullptr;
    ListNode* newHead = new ListNode(head->val);
    ListNode* newCurr = newHead;
    ListNode* curr = head->next;

    while(curr != nullptr) {
        ListNode* nextNode = new ListNode(curr->val);
        newCurr->next = nextNode;
        newCurr = newCurr->next;
        curr = curr->next;
    }

    return newHead;
}

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    ListNode* copy = createCopyOf(head);
    printList(head);
    printList(copy);
}