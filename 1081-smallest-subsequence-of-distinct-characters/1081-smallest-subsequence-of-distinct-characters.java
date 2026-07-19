class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[126];
        boolean[] visited=new boolean[126];
        for(char ch: s.toCharArray())
        {
            freq[ch]++;
        }
        ArrayList<Character> list=new ArrayList<>();
        for(char ch: s.toCharArray())
        {
            if(visited[ch]==true)
            {
                freq[ch]--;
                continue;
            }
            int size=list.size();
            while(size>0)
            {
                char temp=list.get(size-1);
                if(temp>ch && freq[temp]>0)
                {
                    list.remove(size-1);
                    visited[temp]=false;
                }
                else
                {
                    break;
                }
                size--;
            }
            list.add(ch);
            visited [ch]=true;
            freq[ch]--;
        }
        StringBuilder sb=new StringBuilder();
        for(char ch: list)
        {
            sb.append(ch);
        }
        return sb.toString();
    }
}