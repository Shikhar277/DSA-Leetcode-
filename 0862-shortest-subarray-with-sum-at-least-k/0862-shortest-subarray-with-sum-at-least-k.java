class Solution {
    public int shortestSubarray(int[] nums, int k) {
       // Sliding window on prefix sums of nums
       // Step 1 create prefix array where every index stores sum till index-1
       int n=nums.length;
       long prefix[]=new long[n+1]; prefix[0]=0;
       for(int i=0;i<n;i++)
        prefix[i+1]=prefix[i]+nums[i];
       // Step 2 we need a deque to maintain our sliding window and give us the smallest prefix sum seen till now at every    index 
       // It is because we want to use this smallest prefix sum to greedily acheive atleast k smaller the value we subtract from there are more chances to get SUBARRAY WITH ATLEAST K SUM.

       Deque<Integer> dq=new ArrayDeque<>();
       int minLen=n+1;
       for(int i=0;i<n+1;i++)
       {
        // shrink the window till the condition again becomes false and store minimum at ever point of shrinking to get the minimum length of the window
        while(!dq.isEmpty() && prefix[i]-prefix[dq.peekFirst()]>=k) // shrink till condition is false
        {
          minLen=Math.min(minLen,i-dq.peekFirst()); // store minimum
          dq.removeFirst(); // shrink the window
        }

        while(!dq.isEmpty() && prefix[i]<prefix[dq.peekLast()]) // maintain an increasing deque
         dq.removeLast();

         dq.addLast(i);//r++ in sliding window (move forward) expand the window
       }

       return minLen == n+1?-1:minLen;
    }
}