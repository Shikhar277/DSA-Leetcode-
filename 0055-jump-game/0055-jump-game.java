class Solution {
    public boolean canJump(int[] nums){
       int n=nums.length;
       int max_jump=0;
       for(int i=0;i<n;i++)
       {
          if(max_jump<i)
            return false;
           max_jump=Math.max(max_jump,i+nums[i]);
       }
       return true;
    }
}