class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return subarrays(nums,k)-subarrays(nums,k-1);
    }
    public int subarrays(int nums[], int k)
    {
        int l=0,r=0;
        int odd=0;
        int count=0;
        while(r<nums.length)
        {
            if(nums[r]%2!=0)
              odd++;
            while(odd>k)
            {
              if(nums[l]%2!=0)
                odd--;
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}