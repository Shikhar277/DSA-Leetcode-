class Solution {
    public int largestRectangleArea(int[] heights) {
        // At brute force we can try all rectangles
        // But if at any index we greedly find the maximum area of the rectangle it can contain then we can find max of all those areas
        int nse[]=nse(heights);
        int pse[]=pse(heights);
        int max_area=0;
        for(int i=0;i<heights.length;i++)
        {
           max_area=Math.max(max_area,heights[i]*(nse[i]-pse[i]-1)); //(nse[i]-1)-(pse[i]+1)+1
        }
        return max_area;
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
    public int[] pse(int[] arr) // prev smaller element
    {
       Stack<Integer> st=new Stack<>(); // store indexes
       int n=arr.length;
       int psee[]=new int[n];
       for(int i=0;i<n;i++)
       {
         while(!st.isEmpty() && arr[st.peek()]>=arr[i])
         st.pop();
         
         psee[i]=st.isEmpty()?-1:st.peek();
         st.push(i);
       }
       return psee;
    }
}