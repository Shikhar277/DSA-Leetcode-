class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)
        return 0;
        int count=0;
        int l=0,r=0; int prd=1;
        while(r<nums.length)
        {
           prd*=nums[r];
           while(l<=r && prd>=k)
           {
            prd/=nums[l];
            l++;
           }
           count+=r-l+1;
           r++;
        }
        return count;
    }
}