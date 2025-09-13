
public class Solution {
    public int length(ListNode head){
        int count = 0;
        ListNode curr = head;

        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);

        int d = 0;
        ListNode ptr1;
        ListNode ptr2;

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
            ptr1 = ptr1.next;
            if(ptr1 == null){
                return null;
            }
            d--;
        }

        while(ptr1 != null && ptr2 != null){

            if(ptr1 == ptr2){
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

