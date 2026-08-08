class Solution {
    public int[] validSequence(String word1, String word2) {
       int n=word1.length();
        int m=word2.length();

        int[] ans= new int[m];

        // last[j] = position where word2[j]
        // can be matched while processing from right
        int[] last=new int[m];

        // Fill with -1 initially
        java.util.Arrays.fill(last, -1);

        int i = n-1;
        int j = m-1;

        // Find positions for word2 from right to left
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We can use at most one mismatch
        boolean canSkip = true;

        j = 0;

        // Greedily scan word1 from left to right
        for (i = 0; i < n; i++) {

            // All characters of word2 are selected
            if (j == m) {
                break;
            }

            // Characters match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Characters don't match
            else if (canSkip &&
                     (j == m - 1 || i < last[j + 1])) {

                // Use our one allowed mismatch
                canSkip = false;

                ans[j] = i;
                j++;
            }
        }

        // If we could not construct complete answer
        if (j != m) {
            return new int[0];
        }

        return ans;
        }
}