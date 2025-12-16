class Solution {
    public int[] twoSum(int[] numbers, int target){
       int low=0;
       int high=numbers.length-1;
       int mid;
       while(low<=high)
       {
            mid=(low+high)/2;
            int sum=numbers[low]+numbers[high];

            if(sum==target)
               return new int[]{low+1,high+1};
            else if(sum>target)
                high--;
            else
                low++;
       }
       return new int[]{-1,-1};
    }
}