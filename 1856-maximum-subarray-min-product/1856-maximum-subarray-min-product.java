class Solution {
    public int maxSumMinProduct(int[] nums) {
        long prefix[]=new long[nums.length+1];
        prefix[0]=0;
        prefix[1]=nums[0];
        long mod=1000000007L;
        
        for(int i=1;i<nums.length;i++)
        prefix[i+1]=prefix[i]+nums[i];

        int pse[]=pse(nums);
        int nse[]=nse(nums);
        long max_prd=1;
        for(int i=0;i<nums.length;i++)
        {
            int min=nums[i];
            int l=pse[i];
            int r=nse[i];
            max_prd=Math.max(max_prd,(long)min*(prefix[r]-prefix[l+1]));
        }
        return (int)(max_prd%mod);
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