class Solution {
    public int longestValidParentheses(String s) {
        int mx=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1); 
        
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(') 
            {
                st.push(i);
            } 
            else 
            { // c == ')'
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } 
                else 
                {
                    mx= Math.max(mx, i-st.peek());
                }
            }
        }
        
        return mx;
    }
}