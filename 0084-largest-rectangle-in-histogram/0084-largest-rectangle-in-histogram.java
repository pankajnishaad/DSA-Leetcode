class Solution {
    public int largestRectangleArea(int[] heights) {
        // brute force
        // int maxArea=0;
        // int n=heights.length;
        // for(int i=0; i<n; i++)
        // {
        //     int minHeight=Integer.MAX_VALUE;
        //     for(int j=i; j<n; j++)
        //     {
        //         minHeight=Math.min(minHeight, heights[j]);
        //         int width=j-i+1;
        //         int area=width*minHeight;
        //         maxArea=Math.max(maxArea, area);
        //     }
        // }
        // return maxArea;

        // optimal
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0; i<=n; i++)
        {
            int currHeight=(i==n)? 0: heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>currHeight)
            {
                int height=heights[stack.pop()];
                int width;
                if(stack.isEmpty())
                {
                    width=i;
                }
                else
                {
                    width=i-stack.peek()-1;
                }
                int area=height*width;
                maxArea=Math.max(maxArea, area);
            }
            if(i<n)
            {
                stack.push(i);
            }
        }
        return maxArea;
    }
}