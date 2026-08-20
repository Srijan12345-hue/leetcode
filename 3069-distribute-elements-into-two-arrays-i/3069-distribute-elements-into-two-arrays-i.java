class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        List <Integer> arr1=new ArrayList<>();
         List <Integer> arr2=new ArrayList<>();
         arr1.add(nums[0]);
         arr2.add(nums[1]);
         for( int i=2;i< n; i++){
            if(i<n && arr1.get(arr1.size() -1)> arr2.get(arr2.size() -1)) arr1.add(nums[i]);
            else{
                arr2.add(nums[i]);
            }
         }
         List <Integer> combined= new ArrayList<>(arr1);
         combined.addAll(arr2);
           int[] ans = new int[combined.size()];
for (int i = 0; i < combined.size(); i++) {
            ans[i] = combined.get(i);
        }

         return ans;
    }
}