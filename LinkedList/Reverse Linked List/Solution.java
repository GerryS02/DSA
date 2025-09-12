
public class Solution{
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextptr;

        while(curr != null){
            nextptr = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextptr;
        }

        return prev;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}