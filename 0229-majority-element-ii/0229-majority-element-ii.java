class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        int cnt1 = 0;
        int cnt2 = 0;

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // Find candidates
        for (int i = 0; i < n; i++) {

            if (cnt1 == 0 && nums[i] != el2) {
                el1 = nums[i];
                cnt1 = 1;
            }
            else if (cnt2 == 0 && nums[i] != el1) {
                el2 = nums[i];
                cnt2 = 1;
            }
            else if (nums[i] == el1) {
                cnt1++;
            }
            else if (nums[i] == el2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        // Verify candidates
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == el1) {
                cnt1++;
            }
            else if (nums[i] == el2) {
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        int mini = n / 3;

        if (cnt1 > mini) {
            ans.add(el1);
        }

        if (cnt2 > mini) {
            ans.add(el2);
        }

        return ans;
    }
}