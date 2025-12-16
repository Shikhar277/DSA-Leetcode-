class Solution {
    public boolean judgeSquareSum(int c) {
        // 0^2+ (root c)^2=c is possible if one of a and b is 0 and root c is integer
        // So we have to increse a from 0 or decrease b from root c to get the answer
        // hence lower limit can be 1 and upper limit root c
        long low=0,high=(long)(Math.sqrt(c));
        while(low<=high)
        {
            long sum=low*low+high*high;
            if(sum==c)
            return true;
            else if(sum>c)
            high--;
            else
            low++;
        }
        return false;
    }
}