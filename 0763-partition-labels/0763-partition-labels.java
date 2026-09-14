class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        for(int i=0; i<s.length(); i++)
        {
            int index=s.charAt(i)-'a';
            last[index]=i;
        }
        List<Integer> res=new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=0; i<s.length(); i++)
        {
            int index=s.charAt(i)-'a';
            end=Math.max(end, last[index]);
            if(i==end)
            {
                int size=end-start+1;
                res.add(size);
                start=i+1;
            }
        }
        return res;
    }
}