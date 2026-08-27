class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        // Store last k elements
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = nums[n - k + i];
        }

        // Shift the remaining elements to the right
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Put last k elements at the beginning
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        
    }
}