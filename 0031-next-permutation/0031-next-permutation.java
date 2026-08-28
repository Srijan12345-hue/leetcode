class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: Find the first decreasing element from right
        int ind = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // Step 2: If no such index exists,
        // array is in descending order.
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest element greater than nums[ind]
        // from the right side.
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // Step 4: Reverse the part after ind
        reverse(nums, ind + 1, n - 1);
    }

    // Swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse array from left to right
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}