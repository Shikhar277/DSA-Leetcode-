class Solution {
    public long minCost(String s, int[] cost) {
        long total=0;
        HashMap<Character,Long> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,(long)0)+cost[i]);
            total+=cost[i];
        }       
        long  min=Long.MAX_VALUE;
        for(char ch:map.keySet())
            {
                min=Math.min(min,total-map.get(ch));         
            }
        return min;
    }
}