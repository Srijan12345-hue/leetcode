class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            // Maximum from 0 to i
            max = Math.max(max, nums[i]);

            // Find minimum from i to n-1
            min = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
            }

            // Check condition
            if (max - min <= k) {
                return i;
            }
        }

        return -1;
    }
}