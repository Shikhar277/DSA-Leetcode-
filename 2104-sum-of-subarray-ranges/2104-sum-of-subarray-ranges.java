class Solution {
   public long subArrayRanges(int[] nums) {
       // Stack 
       /* Intution :- A subarrays problem requires counting all the subarrays and it talks about largest or smallest element 
          Since there is no monotonic condition sliding window or greedy cant be used so stack might work try to check if not 
          then look for others.

           ~ We need to calculate the contribution of all ranges but for getting all ranges we need to traverse them then again its O(N^2)
           ~ So again think if you start thinking in terms of contribution of all elemts you fail
           ~ Then you think of any sub problem you solved like this we get sub array minimum we found the minimum in the subarray and summed up 
           ~ so if I could find the maximum in the same subarray it would be :-
           `` Sum of all ranges = (sum of all maximums)-(sum of all minimums)
        */
        return sumSubarrayMax(nums)-sumSubarrayMin(nums);
    }
     public long sumSubarrayMin(int[] arr) {
       int count=0;
       int nse[]=nse(arr);
       int psee[]=psee(arr);
       long total=0;
       for(int i=0;i<arr.length;i++)
       {
         int left=i-psee[i];
         int right=nse[i]-i;
         long mins=(long)left*right*arr[i];
         total+=mins;
       }
       return total;
    }
    public long sumSubarrayMax(int[] arr) {
       int count=0;
       int nge[]=nge(arr);
       int pgee[]=pgee(arr);
       long total=0;
       for(int i=0;i<arr.length;i++)
       {
         int left=i-pgee[i];
         int right=nge[i]-i;
         long max=(long)left*right*arr[i];
         total+=max;
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
    
    public int[] nge(int[] arr) // next greater element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int nse[]=new int[n];
       for(int i=n-1;i>=0;i--)
       {
         while(!st.isEmpty() && arr[st.peek()]<=arr[i])
         st.pop();
         
         nse[i]=st.isEmpty()?n:st.peek();
         st.push(i);
       }
       return nse;
    }
    public int[] pgee(int[] arr) // prev greater or equal element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int psee[]=new int[n];
       for(int i=0;i<n;i++)
       {
         while(!st.isEmpty() && arr[st.peek()]<arr[i])
         st.pop();
         
         psee[i]=st.isEmpty()?-1:st.peek();
         st.push(i);
       }
       return psee;
    }
}