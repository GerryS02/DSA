#include <cstddef>
#include <unordered_map>

class LRUCache {
public:

    class Node{
    public:
        int key, val;
        Node* next;
        Node* prev;

        Node(int k, int v){
            key = k;
            val = v;
            next = prev = NULL;
        }
    };

    Node* head = new Node(-1,-1);
    Node* tail = new Node(-1,-1);

    int limit;
    unordered_map<int, Node*> m;

    void addNode(Node* newNode){
        Node* nextNode = head->next;

        head->next = newNode;
        nextNode->prev = newNode;

        newNode->next = nextNode;
        newNode->prev = head;
    }

    void delNode(Node* oldNode){
        Node* oldPrev = oldNode->prev;
        Node* oldNext = oldNode->next;

        oldPrev->next = oldNext;
        oldNext->prev = oldPrev;
    }

    LRUCache(int capacity) {
        limit = capacity;

        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        //if key is not present in the map
        if(m.find(key) == m.end()){
            return -1;
        }

        Node* ansNode = m[key];
        int ans = ansNode->val;

        delNode(ansNode);
        addNode(ansNode);

        return ans;
    }
    
    void put(int key, int value) {
        //if the key is alredy in the map
        if(m.find(key) != m.end()){
            Node* oldNode = m[key];
            delNode(oldNode);
            m.erase(key);
        }

        if(m.size() == limit){
            m.erase(tail->prev->key);
            delNode(tail->prev);
        }

        Node* newNode = new Node(key, value);
        addNode(newNode);
        m[key] = newNode;
    }
};
