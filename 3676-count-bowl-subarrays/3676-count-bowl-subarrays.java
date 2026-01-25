class Solution {
    public long bowlSubarrays(int[] nums) {
       // Intution 
       // For every maximum element in the array you have to find its boundary means its next greater and previous greater element as  
       // given min(nums[l], nums[r]) > max(nums[l + 1], ..., nums[r - 1])
       // count= sum of all sub arrays in which nums[0] is maximum , nums[1] so on... uptill last.


       // We could have used the sliding window but condition is not monotonous rather the condition is such it demands some stacks nge and pge 
       // algorithm and most importantly we are able to do this here since we are sure for every element there will be 1 sub array or there     will not be any sub array
       int pge[]=pge(nums);
       int nge[]=nge(nums);
       long count=0;
       for(int i=0;i<nums.length;i++)
       {
         int l=pge[i];
         int r=nge[i];
         if(l!=-1 && r!=nums.length)
            count++;
       }
    return count;
    }
    public int[] pge(int[] arr) // prev greater element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int pge[]=new int[n];
       for(int i=0;i<n;i++)
       {
         while(!st.isEmpty() && arr[st.peek()]<=arr[i])
         st.pop();
         
         pge[i]=st.isEmpty()?-1:st.peek();
         st.push(i);
       }
       return pge;
    }
     public int[] nge(int[] arr) // next greater element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int nge[]=new int[n];
       for(int i=n-1;i>=0;i--)
       {
         while(!st.isEmpty() && arr[st.peek()]<=arr[i])
         st.pop();
         
         nge[i]=st.isEmpty()?n:st.peek();
         st.push(i);
       }
       return nge;
    }
}