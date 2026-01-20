class Solution {
    public int largestRectangleArea(int[] arr) { 
       int n=arr.length; // pse and nse calculation in one fly go dry run youself no need to read the code
       Stack<Integer> st=new Stack<>(); // store indexes
       int max_area=0;
       int pse=-1,nse=n;
       for(int i=0;i<n;i++)
       {
         while(!st.isEmpty() && arr[st.peek()]>=arr[i])
         {
            nse=i;
            int element=arr[st.pop()]; // for this element nse and pse are being found when we traverse back in the array while popping
            pse=!st.isEmpty()?st.peek():-1;
            max_area=Math.max(max_area,element*(nse-pse-1));
         }
         st.push(i);
       }
       while(!st.isEmpty())
       {
         nse=n;
         int element=arr[st.pop()];
         pse=st.isEmpty()?-1:st.peek();
         max_area=Math.max(max_area,element*(nse-pse-1));
       }
       return max_area;
    }
}