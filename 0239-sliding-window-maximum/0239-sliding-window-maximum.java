class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int n=nums.length; 
        // int[] ans=new int[n-k+1];
        // for(int i=0; i<=n-k; i++)
        // {
        //     int max=nums[i];
        //     for(int j=i; j<i+k; j++)
        //     {
        //         if(nums[j]>max)
        //         {
        //             max=nums[j];
        //         }
                
        //     }
        //     ans[i]=max;
        // }
        // return ans;

        int n=nums.length;
        int[] ans=new int[n-k+1];
        Deque<Integer>deque=new ArrayDeque<>();
        int idx=0;
        for(int right=0; right<n; right++)
        {
            while(!deque.isEmpty() && deque.peekFirst()<=right-k)
            {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[right])
            {
                deque.pollLast();
            }
            deque.offerLast(right);
            if(right>=k-1)
            {
                ans[idx++]=nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}