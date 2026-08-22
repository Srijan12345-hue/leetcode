class Solution {
    public boolean checkDivisibility(int n) {
        boolean ans=false;
        int og=n;
        int sum=0;
        int multiplecation=1;
        while(n>0){
            int ch=n%10;
            sum+= ch;
            multiplecation*=ch;
            n/=10;
        }
        System.out.println(sum+","+multiplecation);
        if(og%(sum + multiplecation )==0){
            ans=true;

        }
        return ans;
    }
}