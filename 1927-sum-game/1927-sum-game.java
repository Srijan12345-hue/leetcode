class Solution {
    public boolean sumGame(String num) {
        int len= num.length();
        int cnt1=0;
        int leftsum=0;
        for(int i=0;i< len/2;i++){
            if(num.charAt(i)=='?') cnt1++;
            else leftsum+=(num.charAt(i)-'0');

        }
        int cnt2=0;
        int rightsum=0;

         for(int i=len/2;i< len;i++){
            if(num.charAt(i)=='?') cnt2++;
            else rightsum+=(num.charAt(i)-'0');

        }
         int totalnumber=cnt1+ cnt2;
         int sumdiff=leftsum-rightsum;
         int diff=cnt2-cnt1;
         return totalnumber % 2==1|| sumdiff != 9*diff/2;
        
    }
}