class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minIdx=0;
        int maxIdx=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i]>nums[maxIdx])
            {
                maxIdx=i;
            }
            if(nums[i]<nums[minIdx])
            {
                minIdx=i;
            }
        }
        int left=Math.max(minIdx, maxIdx)+1;
        int right=Math.max(n-minIdx, n-maxIdx);
        int maxLeftMinRight=(maxIdx+1)+(n-minIdx);
        int maxRightMinLeft=(minIdx+1)+(n-maxIdx);
        return Math.min(
            Math.min(left, right), Math.min(maxLeftMinRight, maxRightMinLeft)
        );
    }
}