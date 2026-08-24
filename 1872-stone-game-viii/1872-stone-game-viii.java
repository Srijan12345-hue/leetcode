class Solution {
    private Integer[] memo;
    private int[] presum;
    private int n;

    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        memo = new Integer[n];

        // Build prefix sum
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        presum = stones;

        return dfs(1);
    }

    public int dfs(int curri) {

        // Base case
        if (curri == n - 1) {
            return presum[curri];
        }

        if (memo[curri] != null) {
            return memo[curri];
        }

        int next = dfs(curri + 1);

        int skip = next;
        int take = presum[curri] - next;

        memo[curri] = Math.max(skip, take);

        return memo[curri];
    }
}