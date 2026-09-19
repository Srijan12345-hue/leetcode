class Solution {
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        for (int left = 0; left < s.length(); left++) {

            for (int right = left; right < s.length(); right++) {

                if (ispalindromic(s, left, right)) {

                    // Check if this palindrome is longer
                    if (right - left > end - start) {
                        start = left;
                        end = right;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public boolean ispalindromic(String s, int l, int r) {

        for (int i = l; i <= (l + r) / 2; i++) {

            if (s.charAt(i) != s.charAt(r + l - i)) {
                return false;
            }
        }

        return true;
    }
}