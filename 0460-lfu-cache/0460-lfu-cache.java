class LFUCache {
    class Node
    {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        Node(int key, int value)
        {
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    class DoublyLinkedList
    {
        Node head;
        Node tail;
        DoublyLinkedList()
        {
            head=new Node(-1, -1);
            tail=new Node(-1, -1);
            head.next=tail;
            tail.prev=head;
        }
        void addFirst(Node node)
        {
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
        }
        void remove(Node node)
        {
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        Node removeLRU()
        {
            if(head.next==tail) return null;
            Node node=tail.prev;
            remove(node);
            return node;
        }
        boolean isEmpty()
        {
            return head.next==tail;
        }
    }
    int capacity;
    int minFreq;
    Map<Integer,Node>keyMap=new HashMap<>();
    Map<Integer, DoublyLinkedList>freqMap=new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;
        Node node=keyMap.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(keyMap.containsKey(key))
        {
            Node node=keyMap.get(key);
            node.value=value;
            updateFreq(node);
            return;
        }
        if(keyMap.size()==capacity)
        {
            DoublyLinkedList list=freqMap.get(minFreq);
            Node removed=list.removeLRU();
            keyMap.remove(removed.key);
            if(list.isEmpty())
            {
                freqMap.remove(minFreq);
            }
        }
        Node node=new Node(key, value);
        keyMap.put(key, node);
        freqMap.computeIfAbsent(1, f->new DoublyLinkedList()).addFirst(node);
        minFreq=1;
    }
    void updateFreq(Node node)
    {
        int oldFreq=node.freq;
        DoublyLinkedList oldList=freqMap.get(oldFreq);
        oldList.remove(node);
        if(oldList.isEmpty())
        {
            freqMap.remove(oldFreq);
            if(minFreq==oldFreq)
            {
                minFreq++;
            }

        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, f->new DoublyLinkedList()).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */