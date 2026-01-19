class Solution {
    public int sumSubarrayMins(int[] arr) {
       int count=0;
       int nse[]=nse(arr);
       int psee[]=psee(arr);
       int mod=(int)(1e9+7);
       int total=0;
       for(int i=0;i<arr.length;i++)
       {
         int left=i-psee[i];
         int right=nse[i]-i;
         int mins=(int)(((long)left*right*arr[i])%mod);
         total=(int)((total+mins)%mod);
       }
       return total;
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
    public int[] psee(int[] arr) // prev smaller or equal element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int psee[]=new int[n];
       for(int i=0;i<n;i++)
       {
         while(!st.isEmpty() && arr[st.peek()]>arr[i])
         st.pop();
         
         psee[i]=st.isEmpty()?-1:st.peek();
         st.push(i);
       }
       return psee;
    }
}