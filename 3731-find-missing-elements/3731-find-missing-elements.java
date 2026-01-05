class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        for(int num:nums)
        {
            min=Math.min(min,num);
            max=Math.max(max,num);
            set.add(num);
        }
        for(int i=min;i<=max;i++)
        {
            if(!set.contains(i))
              ans.add(i);
        }
        return ans;
    }
}