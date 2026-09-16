class Solution {

    private static final int MOD = 1000000007;

    public int numberOfSets(int n, int k) {

        int[][] dp1 = new int[n + 1][k + 1];
        int[][] dp2 = new int[n + 1][k + 1];

        dp1[1][0] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                // dp1: currently not extending a segment
                dp1[i][j] =
                    (dp1[i - 1][j] + dp2[i - 1][j]) % MOD;

                // Continue the current segment
                dp2[i][j] = dp2[i - 1][j];

                if (j > 0) {

                    // Start a new segment from dp1
                    dp2[i][j] =
                        (dp2[i][j] + dp1[i - 1][j - 1]) % MOD;

                    // Start a new segment from dp2
                    dp2[i][j] =
                        (dp2[i][j] + dp2[i - 1][j - 1]) % MOD;
                }
            }
        }

        return (dp1[n][k] + dp2[n][k]) % MOD;
    }
}