class Solution {
    public int minLength(int[] nums, int k) {
        int minLen=Integer.MAX_VALUE;
        int len=0;
        int sum=0,l=0;
        HashMap<Integer,Integer> f=new HashMap<>();
        for(int r=0;r<nums.length;r++)
        {
            f.put(nums[r],f.getOrDefault(nums[r],0)+1);
            if(f.get(nums[r])==1)
               sum+=nums[r];
            while(sum>=k)
            {
                minLen=Math.min(minLen,r-l+1);
                f.put(nums[l],f.get(nums[l])-1);
                if(f.get(nums[l])==0)
                   sum-=nums[l];
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}