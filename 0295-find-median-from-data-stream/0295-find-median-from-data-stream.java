class MedianFinder {
    // List<Integer> list;

    PriorityQueue<Integer>maxHeap;
    PriorityQueue<Integer>minHeap;

    public MedianFinder() {
        // list=new ArrayList();

        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // list.add(num);

        // pahle maxHeap me jayega aur ja koi condition sahi nhi hogi tb minHeap me
        if(maxHeap.isEmpty()|| num<=maxHeap.peek())
        {
            maxHeap.offer(num);
        }
        else
        {
            minHeap.offer(num);
        }
        // dono ki height balance karenge, maxHEap minheap se 1 jade hi hoga
        if(maxHeap.size()>minHeap.size()+1)
        {
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size()>maxHeap.size())
        {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // Collections.sort(list);
        // int n=list.size();
        // if(n%2==1)
        // {
        //     return list.get(n/2);
        // }
        // else
        // {
        //     return (list.get(n/2-1)+list.get(n/2))/2.0;
        // }



        //even;
        if(maxHeap.size()==minHeap.size())
        {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        else
        {
            return maxHeap.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */