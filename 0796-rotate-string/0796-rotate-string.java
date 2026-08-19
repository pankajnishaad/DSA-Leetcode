class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        // char[] ch1=s.toCharArray();
        // char[] ch2=goal.toCharArray();
        // Arrays.sort(ch1);
        // Arrays.sort(ch2);
        // return Arrays.equals(ch1, ch2);
        return (s + s).contains(goal);
    }
}