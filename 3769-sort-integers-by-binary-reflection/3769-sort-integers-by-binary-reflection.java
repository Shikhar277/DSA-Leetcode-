class Solution {
    public int[] sortByReflection(int[] nums) {
       Integer ans[]=new Integer[nums.length];
       for(int i=0;i<nums.length;i++)
          ans[i]=nums[i];
        Arrays.sort(ans,(a,b)->{
            if(binary_reflection(a)!=binary_reflection(b))
              return binary_reflection(a)-binary_reflection(b);
            else
              return a-b;}
              );
        for(int i=0;i<nums.length;i++)
          nums[i]=ans[i];

        return nums;
    }
    public int binary_reflection(int n)
    {
        int ans=0;
        while(n!=0)
        {
            int bit=n&1;
            ans<<=1;
            ans|=bit;
            n>>=1;
        }
        return ans;
    }
}