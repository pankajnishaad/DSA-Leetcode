class Solution {

    int n;

    int[] suffix;

    int[][] dp;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // suffix[i] = total stones from i to n-1
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        // dp[i][M] = maximum stones current player can get
        dp = new int[n][n + 1];

        // 0 means state not calculated
        for (int i = 0; i < n; i++) {
            for (int m = 0; m <= n; m++) {
                dp[i][m] = -1;
            }
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No piles left
        if (i >= n) {
            return 0;
        }

        // If already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        // Opponent will try to maximize their stones
        int opponentMin = Integer.MAX_VALUE;

        // Current player can take 1 to 2*M piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int nextM = Math.max(M, X);

            // Stones opponent can get from remaining game
            int opponent = solve(i + X, nextM);

            // We want opponent to get minimum
            opponentMin = Math.min(opponentMin, opponent);
        }

        // Total remaining stones
        int remaining = suffix[i];

        // Whatever opponent gets, rest belongs to current player
        dp[i][M] = remaining - opponentMin;

        return dp[i][M];
    }
}