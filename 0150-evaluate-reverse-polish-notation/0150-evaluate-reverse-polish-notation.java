class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for(String token: tokens)
        {
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/"))
            {
                stack.push(Integer.parseInt(token));
            }
            else
            {
                int b=stack.pop();
                int a=stack.pop();
                int ans=0;
                if(token.equals("+"))
                {
                    ans=a+b;
                }
                else if(token.equals("-"))
                {
                    ans=a-b;
                }
                else if(token.equals("*"))
                {
                    ans=a*b;
                }
                else if(token.equals("/"))
                {
                    ans=a/b;
                }
                stack.push(ans);
            }
            
        }
        return stack.pop();
    }
}