class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];

        // using priorityqueue- minHeap
        // PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        // for(int num: nums)
        // {
        //     minHeap.offer(num);
        //     if(minHeap.size()>k)
        //     {
        //         minHeap.poll();
        //     }
        // }
        // return minHeap.peek();

        // using priorityqueue- maxHeap
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums)
        {
            maxHeap.offer(num);   
        }
        for(int i=1; i<k; i++)
        {
            maxHeap.poll();   
        }
        return  maxHeap.poll();  
    }
}