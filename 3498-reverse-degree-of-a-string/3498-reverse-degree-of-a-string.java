class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++)
        {
            char ch=s.charAt(i);
            int position=26-(ch-'a');
            sum+=position*(i+1);
        }
        return sum;
    }
}