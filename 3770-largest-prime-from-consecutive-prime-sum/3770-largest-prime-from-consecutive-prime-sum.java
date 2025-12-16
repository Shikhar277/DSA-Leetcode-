class Solution {
    public int largestPrime(int n) {
        int sum=0;
        int ans=0;
        int i=2;
        for(i=2;i<=n;i++)
        {
            if(isPrime(i))
            {
              if(sum+i<=n)
              sum+=i;
              else
              break;
            }
            if(isPrime(sum))
              ans=sum;
        }
        return ans;
    }
    private boolean isPrime(int n)
    {
        if(n==1) return false;
        else if(n==2) return true;
        else if(n%2==0) return false;

        for(int i=3;i*i<=n;i+=2)
        {
            if(n%i==0)
              return false;
        }
        return true;
    }
}