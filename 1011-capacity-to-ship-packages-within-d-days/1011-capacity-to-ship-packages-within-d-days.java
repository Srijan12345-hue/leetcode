class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Minimum capacity = maximum single weight
        // Maximum capacity = sum of all weights
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (capacity(weights, days, mid)) {

                // mid is possible.
                // Try a smaller capacity.
                ans = mid;
                right = mid - 1;

            } else {

                // mid is too small.
                // Need larger capacity.
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean capacity(int[] arr, int d, int cap) {

        int days = 1;
        int sum = 0;

        for (int num : arr) {

            if (sum + num > cap) {

                // Start a new day
                days++;
                sum = num;

            } else {

                sum += num;
            }
        }

        return days <= d;
    }
}