class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // solve using monotonic queue
        // we maintain a queue such that the largest element can be directly taken from the queue.
        int n=nums.length;
        int ans[]=new int[n-k+1];
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
           if(!q.isEmpty() && i-q.peekFirst()>k-1)
            q.removeFirst();

           while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
           q.removeLast();

           q.addLast(i);

           if(i>=k-1)
           ans[i-(k-1)]=nums[q.peekFirst()];
        }
        return ans;
    }
}