class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // type:- number of subarrays with a given sum
        if(goal==0)// base case
           return subarrays(nums,goal);

        return subarrays(nums,goal)-subarrays(nums,goal-1); // subarrays with sum atmost goal - subarrays with sum atmost goal-1
    }
    private int subarrays(int[] nums,int goal)
    {
        int sum=0;
        int l=0,r=0;
        int count=0;
        while(r<nums.length)
        {
            sum+=nums[r];
            while(sum>goal)
            {
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}