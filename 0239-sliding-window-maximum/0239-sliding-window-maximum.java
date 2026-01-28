class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.removeFirst();
            }

            // Remove elements that are smaller than the current element
            while (!q.isEmpty() &&  nums[i] >= nums[q.peekLast()]) {
                q.removeLast();
            }

            // Add current index
            q.offerLast(i);

            // Store result for the current window
            if (i >= k - 1) {
                arr[index++] = nums[q.peekFirst()];
            }
        }
        return arr;
    }
}