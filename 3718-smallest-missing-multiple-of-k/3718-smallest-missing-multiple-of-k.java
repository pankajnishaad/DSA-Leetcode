class Solution {
    public int missingMultiple(int[] nums, int k) {
        int mul=k;
        while(true)
        {
            boolean found=false;
            for(int val: nums)
            {
                if(val==mul)
                {
                    found=true;
                    break;
                }
            }
            if(!found)
            {
                return mul;
            }
            mul+=k;
        
        }
    }
}