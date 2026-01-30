class Solution {
    public int minSubArrayLen(int target, int[] arr) {
       // Binary Search nlogn solution
       // Binary search over the prefix sum of arr
       int n=arr.length;
       long prefix[]=new long[n+1]; prefix[0]=0;
       for(int i=0;i<n;i++)
       prefix[i+1]=prefix[i]+arr[i];

       int minLen=n+1;
       for(int i=0;i<n;i++)
       {
       int l=i+1,h=n;
       while(l<=h)
       {
         int mid=l+(h-l)/2;
         if(prefix[mid]-prefix[i]<target)
         l=mid+1;
         else
         h=mid-1;
       }
       if(l<=n)
       minLen=Math.min(minLen,l-i);
       }
       if(minLen==n+1)
       return 0;
       else
       return minLen;
    }
}