class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost=0;
        if(need1==0 && need2==0)
        return 0;
        if(costBoth < (long)cost1+cost2)
        {
            int min=Math.min(need1,need2);
            cost+=(long)min*costBoth;
            need1-=min;
            need2-=min;
        }
        cost += (long)need1 * Math.min(cost1, costBoth);
        cost += (long)need2 * Math.min(cost2, costBoth);

        return cost;
    }
}