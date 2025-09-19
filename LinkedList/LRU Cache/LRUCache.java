//LRU Cache is implemented using a doubly linked list to efficiently manage the order of access
//for items and maintain quick access to the most and least recently used items.

import java.util.HashMap;

class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            next = prev = null;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    int limit;
    HashMap<Integer, Node> m = new HashMap<>();

    void addNode(Node newNode){
        Node nextNode = head.next;

        head.next = newNode;
        nextNode.prev = newNode;

        newNode.prev = head;
        newNode.next = nextNode;
    }

    void delNode(Node oldNode){
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }

    public LRUCache(int capacity) {
        limit = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!m.containsKey(key)){
            return -1;
        }

        Node ansNode = m.get(key);
        int ans = ansNode.val;

        // m.remove(key);
        delNode(ansNode);

        addNode(ansNode);
        // m.put(key, ansNode);

        return ans;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node oldNode = m.get(key);
            delNode(oldNode);
            m.remove(key);
        }

        if(m.size() == limit){
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        m.put(key, newNode);
    }
}