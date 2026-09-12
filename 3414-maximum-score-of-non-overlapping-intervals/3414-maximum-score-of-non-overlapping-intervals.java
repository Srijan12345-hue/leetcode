class Solution {

    static class State {
        long weight;
        List<Integer> indices;

        State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        if (n == 0) {
            return new int[0];
        }

        // {start, end, weight, originalIndex}
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by end time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[3], b[3]);
        });

        // Find previous non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {

            prev[i] = -1;

            for (int j = i - 1; j >= 0; j--) {

                // Intervals must not overlap
                if (arr[j][1] < arr[i][0]) {
                    prev[i] = j;
                    break;
                }
            }
        }

        /*
         * dp[i][k]:
         * Best solution using first i intervals
         * with at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: don't take current interval
                State skip = dp[i - 1][k];

                // Option 2: take current interval
                int p = prev[i - 1];

                long weight = arr[i - 1][2];

                List<Integer> list = new ArrayList<>();

                if (p != -1) {
                    weight += dp[p + 1][k - 1].weight;
                    list.addAll(dp[p + 1][k - 1].indices);
                }

                list.add(arr[i - 1][3]);

                Collections.sort(list);

                State take = new State(weight, list);

                // Choose the better solution
                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> answer = dp[n][4].indices;

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private State better(State a, State b) {

        // Higher weight is better
        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }

        // Same weight:
        // Lexicographically smaller list is better
        if (lexicographicallySmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean lexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        // If one is a prefix of the other,
        // shorter list is lexicographically smaller.
        return a.size() < b.size();
    }
}