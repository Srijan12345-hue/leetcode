class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int positiveindex=0;
        int negetiveindex=1;
        int [] arr= new int[n];
for(int i=0;i<n;i++){
    if(nums[i] > 0) {
        arr[positiveindex]=nums[i];
        positiveindex+=2;
    }
    else{
        arr[negetiveindex]=nums[i];
        negetiveindex+=2;
    }
}
return arr;
        
    }
}