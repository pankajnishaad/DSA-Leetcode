class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n>m) return "";
        int[]  freq=new int[128];
        for(int i=0; i<n; i++)
        {
            freq[t.charAt(i)]++;
        }
        int left=0;
        int req=n; 
        int minLen=Integer.MAX_VALUE;
        int start=0;
        for(int right=0; right<m; right++)
        {
            char ch=s.charAt(right);
            if(freq[ch]>0) req--;
            freq[ch]--;
            while(req==0)
            {
                int len=right-left+1;
                if(len<minLen)
                {
                    minLen=len;
                    start=left;
                }
                char leftChar=s.charAt(left);
                freq[leftChar]++;
                if(freq[leftChar]>0)
                {
                    req++;
                }
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE)
        {
            return "";
        }
        return s.substring(start, start+minLen);
    }
}