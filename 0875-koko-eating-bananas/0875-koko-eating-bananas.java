class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int max=piles[0];
        for(int i=1; i<piles.length;i++){
            if(max< piles[i]) max=piles[i];
        }
        int right=max;
        int ans=max;
         

        while(left<= right){
            int mid=left+(right-left)/2;
            if(canfinish(piles, h, mid)){
                ans=mid;
                right=mid - 1;
            }
            else left=mid +  1;
        }
        return ans;
        
    }
    public boolean canfinish(int [] arr, int h, int k){
        long hour=0;
        for(int num : arr){
            hour+=num / k;
            if(num % k!=0) hour++;

        }
        return hour<=h;
    }
}