class Solution {

    public int reversePairs(int[] nums) {
        return margesort(nums, 0, nums.length - 1);
    }

    public int margesort(int[] arr, int l, int r) {

        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;

        int count = 0;

        count += margesort(arr, l, mid);
        count += margesort(arr, mid + 1, r);

        count += reversePartition(arr, l, mid, r);

        marge(arr, l, mid, r);

        return count;
    }

    public int reversePartition(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {

            while (right <= high &&
                   (long) nums[i] > 2L * nums[right]) {
                right++;
            }

            cnt += right - (mid + 1);
        }

        return cnt;
    }

    public void marge(int[] nums, int low, int mid, int high) {

        List<Integer> ans = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                ans.add(nums[left]);
                left++;
            } else {
                ans.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            ans.add(nums[left]);
            left++;
        }

        while (right <= high) {
            ans.add(nums[right]);
            right++;
        }

        for (int i = 0; i < ans.size(); i++) {
            nums[low + i] = ans.get(i);
        }
    }
}