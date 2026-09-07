class Solution {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        if (nums.length == 0)
            return ans;

        // First occurrence
        while (left < right) {
            int m = left + (right - left) / 2;

            if (nums[m] < target)
                left = m + 1;
            else
                right = m;
        }

        if (nums[left] == target)
            ans[0] = left;

        // Last occurrence
        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int m = left + (right - left + 1) / 2;

            if (nums[m] > target)
                right = m - 1;
            else
                left = m;
        }

        if (nums[left] == target)
            ans[1] = left;

        return ans;
    }
}