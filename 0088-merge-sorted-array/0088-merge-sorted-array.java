class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] arr = new int[m + n];

        int left = 0;
        int right = 0;
        int index = 0;

        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                arr[index++] = nums1[left++];
            } else {
                arr[index++] = nums2[right++];
            }
        }

        while (left < m) {
            arr[index++] = nums1[left++];
        }

        while (right < n) {
            arr[index++] = nums2[right++];
        }

        // Copy merged array back to nums1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }
}