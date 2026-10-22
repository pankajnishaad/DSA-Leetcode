class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the shorter array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        // Number of elements required on the left side
        int half = (m + n + 1) / 2;

        while (low <= high) {
            // Choose a partition in nums1
            int cut1 = low + (high - low) / 2;

            // Balance the total number of left elements
            int cut2 = half - cut1;

            // Left and right boundaries of nums1
            int left1 = (cut1 == 0)
                    ? Integer.MIN_VALUE : nums1[cut1 - 1];

            int right1 = (cut1 == m)
                    ? Integer.MAX_VALUE : nums1[cut1];

            // Left and right boundaries of nums2
            int left2 = (cut2 == 0)
                    ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right2 = (cut2 == n)
                    ? Integer.MAX_VALUE : nums2[cut2];

            // Check whether both partitions are correct
            if (left1 <= right2 && left2 <= right1) {

                // Odd total length
                if ((m + n) % 2 != 0) {
                    return Math.max(left1, left2);
                }

                // Even total length
                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);

                return ((double) leftMax + rightMin) / 2;
            }

            // nums1 left partition is too large
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // nums1 left partition is too small
            else {
                low = cut1 + 1;
            }
        }

        return 0.0; // Unreachable for valid input
    }
}