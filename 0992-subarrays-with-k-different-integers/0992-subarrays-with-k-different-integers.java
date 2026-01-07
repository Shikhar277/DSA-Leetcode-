class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrays(nums,k)-subarrays(nums,k-1);
    }
    public int subarrays(int nums[],int k)
    {
        HashMap<Integer,Integer> f=new HashMap<>();
        int l=0,r=0;
        int count=0;
        while(r<nums.length)
        {
            f.put(nums[r],f.getOrDefault(nums[r],0)+1);
            while(f.size()>k)
            {
               f.put(nums[l],f.get(nums[l])-1);
               if(f.get(nums[l])==0)
                  f.remove(nums[l]);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}