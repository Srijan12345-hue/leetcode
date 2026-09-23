class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int totalSum = 0;

        // Prefix sum
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];

            // Store first occurrence
            if (!map.containsKey(totalSum)) {
                map.put(totalSum, i);
            }
        }

        int remainingSum = totalSum - x;

        // Case: remove all elements
        if (remainingSum == 0) {
            return n;
        }

        // Case: impossible
        if (remainingSum < 0) {
            return -1;
        }

        int prefixSum = 0;
        int longestSubarray = -1;

        for (int i = 0; i < n; i++) {

            prefixSum += nums[i];

            int findSum = prefixSum - remainingSum;

            if (map.containsKey(findSum)) {

                int idx = map.get(findSum);

                if (idx < i) {
                    longestSubarray = Math.max(
                        longestSubarray,
                        i - idx
                    );
                }
            }
        }

        if (longestSubarray == -1) {
            return -1;
        }

        return n - longestSubarray;
    }
}