class Solution {
    public int trap(int[] height) {
      // solve using prefix max and suffix max
      int n=height.length;
      int pre_max[]=new int[n];
      int suff_max[]=new int[n];
      pre_max[0]=height[0];
      suff_max[n-1]=height[n-1];

      for(int i=1;i<n;i++)
         pre_max[i]=Math.max(pre_max[i-1],height[i]);

      for(int i=n-2;i>=0;i--)
         suff_max[i]=Math.max(suff_max[i+1],height[i]);  

      int total_trap=0; // total trapped water
      for(int i=1;i<n-1;i++)
      {
        int left_max=pre_max[i];
        int right_max=suff_max[i];
        if(height[i]<left_max && height[i]<right_max)
           total_trap+=Math.min(left_max,right_max)-height[i];
      }
      return total_trap;
    }
}