class Solution {

    public int pivotIndex(int[] arr) {

        int n = arr.length;

        int[] pref = new int[n];
        int[] suff = new int[n];

        // Index 0 ke left mein kuch nahi hai
        pref[0] = 0;

        // Har index ke left ka sum
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + arr[i - 1];
        }

        // Last index ke right mein kuch nahi hai
        suff[n - 1] = 0;

        // Har index ke right ka sum
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + arr[i + 1];
        }

        // Left sum == Right sum check karo
        for (int i = 0; i < n; i++) {

            if (pref[i] == suff[i]) {
                return i;
            }
        }

        return -1;
    }
}