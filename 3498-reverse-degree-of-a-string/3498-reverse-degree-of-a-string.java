class Solution {
    public int reverseDegree(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int reverseIndex = 26 - (s.charAt(i) - 'a');

            ans += reverseIndex * (i + 1);
        }

        return ans;
    }
}