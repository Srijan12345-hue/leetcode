class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = 1;
        int max = bloomDay[0];

        for (int i = 1; i < bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
        }

        int right = max;
        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (bloom(bloomDay, m, k, mid) == 1) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int bloom(int[] arr, int m, int k, int day) {

        int count = 0;
        int bucket = 0;

        for (int num : arr) {

            if (num <= day) {
                count++;

                if (count == k) {
                    bucket++;
                    count = 0;
                }
            } else {
                count = 0;
            }

            if (bucket >= m) {
                return 1;
            }
        }

        return -1;
    }
}