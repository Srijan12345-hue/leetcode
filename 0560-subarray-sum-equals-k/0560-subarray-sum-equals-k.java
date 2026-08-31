class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new  HashMap<>();
        map.put(0,1);
        int presum=0;
        int cnt=0;
        int remove=0;
        for(int i=0; i< nums.length; i++){
            presum += nums[i];
        
                 remove= presum -k;
                
            
         cnt += map.getOrDefault(remove, 0);
           map.put(presum, map.getOrDefault(presum, 0) + 1);


        }
        return cnt;
    }
}