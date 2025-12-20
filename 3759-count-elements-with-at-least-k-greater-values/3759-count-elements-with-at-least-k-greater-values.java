class Solution {
    public int countElements(int[] nums, int k){
        if(k==0)
        return nums.length;
       Arrays.sort(nums);
       int kth=nums[nums.length-k];
       int count=0;
       for(int num:nums)
           if(kth>num)
             count++;
        return count;
    }
}