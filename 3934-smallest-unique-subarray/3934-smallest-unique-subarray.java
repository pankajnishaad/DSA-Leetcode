class Solution {
    private static final long BASE1 = 1315423911L;
    private static final long MOD1 = 1_000_000_007L;
    private static final long BASE2 = 13331L;
    private static final long MOD2 = 1_000_000_009L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasUniqueSubarray(nums, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUniqueSubarray(int[] nums, int len) {
        int n = nums.length;
        long h1 = 0, h2 = 0;
        long p1 = 1, p2 = 1;

        for (int i = 0; i < len - 1; i++) {
            p1 = (p1 * BASE1) % MOD1;
            p2 = (p2 * BASE2) % MOD2;
        }

        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i >= len) {
                h1 = (h1 - (nums[i - len] * p1) % MOD1 + MOD1) % MOD1;
                h2 = (h2 - (nums[i - len] * p2) % MOD2 + MOD2) % MOD2;
            }
            h1 = (h1 * BASE1 + nums[i]) % MOD1;
            h2 = (h2 * BASE2 + nums[i]) % MOD2;

            if (i >= len - 1) {
                long combinedHash = (h1 << 32) | h2;
                freq.put(combinedHash, freq.getOrDefault(combinedHash, 0) + 1);
            }
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}
