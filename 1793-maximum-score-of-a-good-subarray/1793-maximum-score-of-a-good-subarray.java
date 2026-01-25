class Solution {
    public int maximumScore(int[] nums, int k) {
        // concept of pse and nse
        int pse[]=pse(nums);
        int nse[]=nse(nums);
        int max_score=0;
        for(int i=0;i<nums.length;i++)
        {
            int l=pse[i]+1;
            int r=nse[i]-1;
            if(l<=k && k<=r)
            max_score=Math.max(max_score,nums[i]*(r-l+1));
        }
        return max_score;
    }
    public int[] pse(int[] arr) // prev smaller element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int pse[]=new int[n];
       for(int i=0;i<n;i++)
       {
         while(!st.isEmpty() && arr[st.peek()]>=arr[i])
         st.pop();
         
         pse[i]=st.isEmpty()?-1:st.peek();
         st.push(i);
       }
       return pse;
    }
       public int[] nse(int[] arr) // next smaller element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int nse[]=new int[n];
       for(int i=n-1;i>=0;i--)
       {
         while(!st.isEmpty() && arr[st.peek()]>=arr[i])
         st.pop();
         
         nse[i]=st.isEmpty()?n:st.peek();
         st.push(i);
       }
       return nse;
    }
}