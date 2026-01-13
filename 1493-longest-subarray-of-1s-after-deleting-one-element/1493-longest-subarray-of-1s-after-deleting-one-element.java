class Solution {
    public int longestSubarray(int[] nums) {
       // Sliding window with atmost one 0
       int count_zeros=0;
       int l=0,r=0;
       int maxlen=0;
       while(r<nums.length)
       {
         if(nums[r]==0) count_zeros++;
         if(count_zeros>1)
         {
            if(nums[l]==0) count_zeros--;
            l++;
         }
         else
         {
             maxlen=Math.max(maxlen,r-l+1);
         }
         r++;
       }
       if(maxlen==0)
         return 0;
       return maxlen-1; // Length Should be reduced by 1 because the element is deleted
    }
}