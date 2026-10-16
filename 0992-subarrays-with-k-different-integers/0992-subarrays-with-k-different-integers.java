class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }
    private int atMost(int[] nums, int k)
    {
        int n=nums.length;
        if(k<0) return 0;
        int[] freq=new int[n+1];
        int left=0, distinct=0, count=0;
        for(int right=0; right<n; right++)
        {
            int num=nums[right];
            if(freq[num]==0) distinct++;
            freq[num]++;
            while (distinct > k) 
            {
                int leftNum = nums[left];
                freq[leftNum]--;
                if(freq[leftNum]==0) 
                {
                    distinct--;
                }
            left++;
        }
            count+=right-left+1;
        }
        return count;
    }
}