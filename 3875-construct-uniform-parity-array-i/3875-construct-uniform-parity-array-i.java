class Solution {
    public boolean uniformArray(int[] nums) {
        int n=nums.length;
        int [] arr= new int[n];
        for(int i=0;i<n-1;i++){
            if(nums[i] %2==0|| nums[i+1] %2==0){
                arr[i]=nums[i];
            }
            else if(nums[i] %2==0 && nums[i+1] % 2==1){
                arr[i]=nums[i]-nums[i+1];            }

        }  
        for(int i=0;i<n;i++){
            if(arr[i] %2==1 && arr[i] %2==0){
                return false;
            }
        }     
        return true;
        
    }
}