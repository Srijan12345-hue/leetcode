class Solution {
    public int majorityElement(int[] s) {
        int n=s.length;
        int cnt=0;
        int ls=0;
      
        for(int i=0;i<n;i++){
            if(cnt==0){
                 ls=s[i];
                cnt=1;

            }
            else if(s[i]==ls){
                cnt ++;

            }
            else if(s[i]!=ls){
                cnt--;
            }

        }
        int count=0;
        for(int i=0;i<n;i++){
            if(s[i]==ls) count++;
          
        }
        if(count> n/2){
            return ls;
        }
        return -1;
    }
}