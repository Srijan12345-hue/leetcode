class Solution {
    public int beautySum(String s) {

        int beauty = 0;

        for (int left = 0; left < s.length(); left++) {

            int[] freq = new int[26];

            for (int right = left; right < s.length(); right++) {

                // Add current character
                freq[s.charAt(right) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                // Find max and min frequency
                for (int i = 0; i < 26; i++) {

                    if (freq[i] > 0) {
                        max = Math.max(max, freq[i]);
                        min = Math.min(min, freq[i]);
                    }
                }

                beauty += max - min;
            }
        }

        return beauty;
    }
}