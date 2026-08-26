class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();
        int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // If we have more than k ones, move left
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // If we have exactly k ones
            if (ones == k) {

                // Remove leading zeros
                while (left <= right && s.charAt(left) == '0') {
                    left++;
                }

                // Remove trailing zeros
                int end = right;

                while (end >= left && s.charAt(end) == '0') {
                    end--;
                }

                String current = s.substring(left, end + 1);

                if (ans.isEmpty()
                        || current.length() < ans.length()
                        || (current.length() == ans.length()
                            && current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}