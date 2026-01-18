class Solution {
    public int trap(int[] height) {
      // solve using two pointer left and right
      int n=height.length;
      int l=0,r=n-1;
      int lmax=height[l],rmax=height[r];
      int total_trap=0;
      while(l<r)
      {
         if(height[l]<=height[r])
         {
           if(lmax>height[l])
              total_trap+=lmax-height[l];
           else
              lmax=height[l];
           l++;
         }
         else
         {
            if(rmax>height[r])
              total_trap+=rmax-height[r];
            else
              rmax=height[r];
           r--;
         }
      }
      return total_trap;
    }
}