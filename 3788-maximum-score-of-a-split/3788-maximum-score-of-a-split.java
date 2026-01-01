class Solution {
    public long maximumScore(int[] nums) {
        long prei=0;// prefix sum
        int n=nums.length;
        int suff[]=new int[n];
        long max_score=Long.MIN_VALUE;
        suff[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--)
           suff[i]=Math.min(suff[i+1],nums[i]);

        for(int i=0;i<n-1;i++)
        {
            prei+=nums[i];
            max_score=Math.max(max_score,prei-suff[i+1]);
        }
        return max_score;
    }
}