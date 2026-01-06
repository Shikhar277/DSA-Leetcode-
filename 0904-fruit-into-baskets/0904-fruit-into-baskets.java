class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> baskets=new HashMap<>(); // stores at max 3 objects so takes approx O(1) time for general operations
        int l=0,r=0;
        int max_fruits=0;
        while(r<fruits.length)
        {
            baskets.put(fruits[r],baskets.getOrDefault(fruits[r],0)+1);
            if(baskets.size()>2)
            {
              baskets.put(fruits[l],baskets.get(fruits[l])-1);
              if(baskets.get(fruits[l])==0)
                baskets.remove(fruits[l]);
              l++;
            }
            else
            {
                max_fruits=Math.max(max_fruits,r-l+1);
            }
            r++;
        }
        return max_fruits;
    }
}