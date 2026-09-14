class Solution {
    public int splitArray(int[] nums, int k) {
        if(k> nums.length) return -1;
        int left=0;
        int right=0;
         for (int num : nums){
            left= Math.max(num, left);
            right += num;
         }
         int ans=right;
          while(left <= right){
            int mid= left + (right-left)/2;
            if(spilted(nums, k, mid)){
                ans=mid;
                 right= mid-1;

            }

               else left=mid+1;
          }
        return ans;
    }
    public boolean spilted(int [] arr, int k, int sum){
        int m=1;
        int pos=0;
        for(int i=0;i< arr.length; i++){
            if(pos + arr[i] <= sum){
                pos +=arr[i];
            }
            else{
                m++;
                pos=arr[i];
            }
        }
        return m <=k;
    }
}