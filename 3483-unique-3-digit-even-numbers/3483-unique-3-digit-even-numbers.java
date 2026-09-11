class Solution {
    public int totalNumbers(int[] digits) {
        int total=0;
        int n=digits.length;
        int [] digitcount= new int[10];
        Arrays.fill(digitcount,0);
        for(int i=0;i<n;i++){
            digitcount[digits[i]]++;
        }
         for(int i=1; i<=9;i++){
            if(digitcount[i]==0) continue;
            digitcount[i]--;
            for(int j=0;j<=9;j++){
                if(digitcount[j]==0) continue;
                digitcount[j]--;
                for(int k=0; k<=8;k+=2){
                    if(digitcount[k]==0) continue;
                    digitcount[k]--;
                    total++;
                    digitcount[k]++;
                }
                digitcount[j]++;
            }
            digitcount[i]++;
         }
         return total;
        
    }
}