class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[0];

        for (int i = 1; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (divisor(nums, threshold, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean divisor(int[] arr, int threshold, int divisor) {
        int sum = 0;

        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }
}