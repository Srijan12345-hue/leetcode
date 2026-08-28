class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check whether a palindrome is possible
        int oddCount = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;

        // Frequency of characters in the left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        /*
         * STEP 1:
         * Try to make the left half exactly equal to
         * target's left half.
         *
         * Example:
         * target = abaa
         * left   = ab
         *
         * palindrome = abba
         *
         * Since abba > abaa, return abba.
         */
        int[] cnt = halfFreq.clone();
        char[] left = new char[halfLen];

        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {

            int c = target.charAt(i) - 'a';

            if (cnt[c] == 0) {
                possible = false;
                break;
            }

            left[i] = target.charAt(i);
            cnt[c]--;
        }

        if (possible) {

            String candidate = buildPalindrome(left, middle, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * STEP 2:
         * The equal left-half palindrome was not greater.
         *
         * Now find the rightmost position where we can
         * increase the left half.
         */
        for (int pos = halfLen - 1; pos >= 0; pos--) {

            cnt = halfFreq.clone();
            left = new char[halfLen];

            boolean ok = true;

            // Keep prefix equal to target
            for (int i = 0; i < pos; i++) {

                int c = target.charAt(i) - 'a';

                if (cnt[c] == 0) {
                    ok = false;
                    break;
                }

                left[i] = target.charAt(i);
                cnt[c]--;
            }

            if (!ok) {
                continue;
            }

            // Find smallest character greater than target[pos]
            int current = target.charAt(pos) - 'a';

            int greater = -1;

            for (int c = current + 1; c < 26; c++) {

                if (cnt[c] > 0) {
                    greater = c;
                    break;
                }
            }

            if (greater == -1) {
                continue;
            }

            // Increase this position
            left[pos] = (char) ('a' + greater);
            cnt[greater]--;

            // Fill remaining positions with smallest characters
            int index = pos + 1;

            for (int c = 0; c < 26; c++) {

                while (cnt[c] > 0) {
                    left[index++] = (char) ('a' + c);
                    cnt[c]--;
                }
            }

            String candidate = buildPalindrome(left, middle, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        return "";
    }

    private String buildPalindrome(
            char[] left,
            char middle,
            int n) {

        StringBuilder sb = new StringBuilder();

        // Left half
        for (char c : left) {
            sb.append(c);
        }

        // Middle character
        if (n % 2 == 1) {
            sb.append(middle);
        }

        // Right half
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}