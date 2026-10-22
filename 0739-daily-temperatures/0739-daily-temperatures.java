class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // int n=temperatures.length;
        // int[] ans=new int[n];
        // for(int i=0; i<n; i++)
        // {
        //     for(int j=i+1; j<n; j++)
        //     {
        //         if(temperatures[j]>temperatures[i])
        //         {
        //             ans[i]=j-i;
        //             break;
        //         }
        //     }
        // }
        // return ans;

        //using stack

        int n=temperatures.length;
        int[] ans=new int[n];
        Stack<Integer>stack=new Stack<>();

        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                int prevDay=stack.pop();
                ans[prevDay]=i-prevDay;
            }
            stack.push(i);
        }
        return ans;
    }
}