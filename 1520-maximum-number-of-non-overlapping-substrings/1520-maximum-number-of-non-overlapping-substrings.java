class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Try every character
        for (int i = 0; i < 26; i++) {

            if (first[i] == -1) {
                continue;
            }

            int left = first[i];
            int right = last[i];

            boolean valid = true;

            // Check all characters inside [left, right]
            for (int j = left; j <= right; j++) {

                int curr = s.charAt(j) - 'a';

                // This character appeared before left
                if (first[curr] < left) {
                    valid = false;
                    break;
                }

                // Extend right if necessary
                right = Math.max(right, last[curr]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort according to ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int end = -1;

        // Select non-overlapping intervals
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > end) {

                ans.add(s.substring(left, right + 1));

                end = right;
            }
        }

        return ans;
    }
}