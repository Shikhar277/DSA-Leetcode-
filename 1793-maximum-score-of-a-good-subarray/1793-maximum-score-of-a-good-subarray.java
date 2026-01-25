class Solution {
    public int maximumScore(int[] nums, int k) {
        // two pointer approach
        // there is a clear hint that k is [i,j] closed interval both included
        // Now start two pointers from k and keep on moving them apart till the condition is true at last store the max value this is how
        // greed works here.
        // Actually visulisation is very important which makes this Question very easy all the sub arrays which have the kth element in it are
        // good sub arrays so take and consider only those arrays which have k th element in them rather considering all the subarrays.

        // Easy to understand
        int i=k;int j=k;
        int n=nums.length;
        int min=nums[k];
        int max_score=nums[k];
        while(i>0 || j<n-1)
        {
            if(i==0)
            j++;
            else if(j==n-1)
            i--;
            else if(nums[i-1]<nums[j+1]) // moving right is preferred because we want to maximise our  minimum value to get maximum score so    move towards the  maximum value
            j++;
            else 
            i--;
            min=Math.min(min,Math.min(nums[i],nums[j]));
            max_score=Math.max(max_score,min*(j-i+1));
        }
        return max_score;
    }
} 