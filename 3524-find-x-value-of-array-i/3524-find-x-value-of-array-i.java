class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            int val = num % k;

            long[] next = new long[k];

            // Start a new subarray
            next[val]++;

            // Extend previous subarrays
            for (int i = 0; i < k; i++) {

                if (dp[i] == 0) {
                    continue;
                }

                int newRemainder = (i * val) % k;

                next[newRemainder] += dp[i];
            }

            // Add current subarrays to answer
            for (int j = 0; j < k; j++) {
                ans[j] += next[j];
            }

            // Current becomes previous
            dp = next;
        }

        return ans;
    }
}