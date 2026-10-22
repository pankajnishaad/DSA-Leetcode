class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight: weights)
        {
            low=Math.max(low, weight);
            high+=weight;
        }
        while(low<high)
        {
            int mid=low+(high-low)/2;
            int reqDays=1;
            int currLoad=0;
            for(int weight: weights)
            {
                // int a=currLoad+weight;
                if(currLoad+weight>mid)
                {
                    reqDays++;
                    currLoad=0;
                }
                currLoad+=weight;

            }
            if(reqDays<=days)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}