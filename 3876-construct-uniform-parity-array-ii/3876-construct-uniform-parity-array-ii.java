class Solution {
    public boolean uniformArray(int[] nums1) {
        final int INF = Integer.MAX_VALUE;
        int minOdd = INF;
        for (int x : nums1) {
            if (x % 2 == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }
        for (int x : nums1) {
            if (x % 2 == 0 && minOdd != INF && x < minOdd) {
                return false;
            }
        }
        return true;
    }
}