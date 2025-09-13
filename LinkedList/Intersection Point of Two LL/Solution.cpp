#include <cstddef>
class Solution{
public:
    struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
    };

    int length(ListNode* head){
        int count = 0;

        while(head != NULL){
            head = head->next;
            count++;
        }
        return count;

    }

    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int len1 = length(headA);
        int len2 = length(headB);

        int d = 0;
        ListNode* ptr1;
        ListNode* ptr2;

        if(len1 > len2){
            d = len1 - len2;
            ptr1 = headA;
            ptr2 = headB;
        }else{
            d = len2 - len1;
            ptr1 = headB;
            ptr2 = headA;
        }

        while(d>0){
            ptr1 = ptr1->next;
            if(ptr1 == NULL){
                return NULL;
            }

            d--;
        }

        while(ptr1 != NULL && ptr2 != NULL){

            if(ptr1 == ptr2){
                return ptr1;
            }
            ptr1 = ptr1->next;
            ptr2 = ptr2->next;
        }
        return NULL;
        
    }
};