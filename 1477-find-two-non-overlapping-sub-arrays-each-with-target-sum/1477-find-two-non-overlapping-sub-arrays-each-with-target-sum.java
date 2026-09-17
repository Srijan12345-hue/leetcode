class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000000;

        // best[i] = shortest target-sum subarray
        // completely inside arr[0 ... i-1]
        int[] best = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Shrink window
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // By default, carry forward the previous best
            best[right + 1] = best[right];

            if (sum == target) {

                int length = right - left + 1;

                // Previous subarray must end before 'left'
                if (best[left] != INF) {
                    answer = Math.min(
                        answer,
                        length + best[left]
                    );
                }

                // Save current subarray
                best[right + 1] =
                    Math.min(best[right + 1], length);
            }
        }

        return answer == INF ? -1 : answer;
    }
}