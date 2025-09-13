import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        //if the head is null, just return null as there's nothing to copy
        if(head == null) return null;

        //hashmap to store the mapping between original nodes and their copied nodes
        HashMap<Node, Node> m = new HashMap<>();

        //create the new head node, which is the copy of the original head node
        Node newHead = new Node(head.val);

        //use two pointers: one for the original list (oldTemp) and one for the new list (newTemp)
        Node oldTemp = head.next;
        Node newTemp = newHead;

        //add the mapping of the original head to the new head into the HashMap
        m.put(head, newHead);

        //traverse the original list to copy the nodes and link them together in the new list
        while(oldTemp != null){
            //create a copy of the current node in the original list
            Node copyNode = new Node(oldTemp.val);
            //add the mapping between the original node and its copy in the HashMap
            m.put(oldTemp, copyNode);

            //link the copied node to the new list
            newTemp.next = copyNode;

            //move to the next node in both original and new lists
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        //reset oldTemp and newTemp to the head of the original and new lists
        oldTemp = head;
        newTemp = newHead;

        //now copy the random pointer for each node in the new list
        while(oldTemp != null){
            //set the random pointer of the new node to the copied node of the corresponding random node
            newTemp.random = m.get(oldTemp.random);

            //move to the next node in both original and new lists
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        //return the new head which is the copied list
        return newHead;
    }
}

class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
}