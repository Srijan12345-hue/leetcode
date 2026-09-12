class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] ans = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        // Merge both sorted arrays
        while (i < m && j < n) {

            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        // Remaining elements of nums1
        while (i < m) {
            ans[k++] = nums1[i++];
        }

        // Remaining elements of nums2
        while (j < n) {
            ans[k++] = nums2[j++];
        }

        int total = m + n;

        // Odd
        if (total % 2 == 1) {
            return ans[total / 2];
        }

        // Even
        return (ans[total / 2 - 1] + ans[total / 2]) / 2.0;
    }
}