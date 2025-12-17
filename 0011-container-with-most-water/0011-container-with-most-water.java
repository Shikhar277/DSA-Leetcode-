class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max_area=0;
        while(left<right)
        {
            max_area=Math.max(max_area,Math.min(height[left],height[right])*(right-left));

            // updations
            if(height[left]<height[right])
              left++;
   
            else if(height[right]<height[left])
              right--;

            else{
              left++; right--;
            }
        }
        return max_area;
}
}