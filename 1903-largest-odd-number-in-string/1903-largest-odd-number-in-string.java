class Solution {
    public String largestOddNumber(String num) {

        int[] nums = new int[num.length()];

        // Convert String to integer array
        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }

        // Find the rightmost odd digit
        int index = -1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] % 2 == 1) {
                index = i;
                break;
            }
        }

        // No odd digit
        if (index == -1) {
            return "";
        }

        // Return all digits up to the rightmost odd digit
        return num.substring(0, index + 1);
    }
}