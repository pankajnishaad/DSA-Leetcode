class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        for(int asteroid: asteroids)
        {
            boolean alive=true;
            while(alive && asteroid<0 && !stack.isEmpty() && stack.peek()>0)
            {
                int top=stack.peek();
                if(top<-asteroid)
                {
                    stack.pop();
                    alive=true;
                }
                else if(top==-asteroid)
                {
                    stack.pop();
                    alive=false;
                }
                else           //top>-asteroid
                {
                    alive=false;
                }
            }
            if(alive)
            {
                stack.push(asteroid);
            }
        }
        int n=stack.size();
        int[] ans=new int[n];
        // for(int i=0; i<n; i++)
        // {
        //     ans[i]=stack.get(i);
        // }
        for(int i=n-1; i>=0; i--)
        {
            ans[i]=stack.pop();
        }
        return ans;
    }
}