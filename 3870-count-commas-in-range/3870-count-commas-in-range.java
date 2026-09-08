class Solution {
    public int countCommas(int n) {
        int x=n;
        int count=0;
        int ans=0;
        while(x>0){
            int digit= x %10;
            if(digit<=9){
                count ++;
            }
            x/=10;
        }
        if(count <=3){
            ans= 0;
        }
        else{
            if(n>999){
                int num=n-999;
                ans=num;
            }
        }
        return ans;
        
    }
}