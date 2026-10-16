class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        if(m>n) return ans;
        int[] freqP=new int[26];
        int[] freqS=new int[26];
        for(int i=0; i<m; i++)
        {
            freqP[p.charAt(i)-'a']++;
            freqS[s.charAt(i)-'a']++;
        }
        if(matches(freqP, freqS))
        {
            ans.add(0);
        }
        for(int right=m; right<n; right++)
        {
            freqS[s.charAt(right)-'a']++;
            freqS[s.charAt(right-m)-'a']--;
            if(matches(freqP, freqS))
            {
                ans.add(right-m+1);
            }
        }
        return ans;
    }
    private boolean matches(int[] a, int[]b)
    {
        for(int i=0; i<26; i++)
        {
            if(a[i]!=b[i])
            {
                return false;
            }
        }
        return true;
    }
}