class Solution {
    public int minimumDeletions(int[] arr) {
        int n=arr.length;
        int maxindex=0;
        int minindex=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
          if(arr[i]>max){
            maxindex=i;
           max=Math.max(arr[i], max);
          }
         if (arr[i] < arr[minindex]) {
    minindex = i;
     min=Math.min(arr[i], min);
    
}

        }
    int left = Math.min(minindex, maxindex);
        int right = Math.max(minindex, maxindex);
        int option1 = right + 1;
        int option2 = n - left;
        int option3 = (left + 1) + (n - right);

        return Math.min(option1, Math.min(option2, option3));
    }
    }
