class Solution {
    public int countPrimes(int n) {
        int c=0;
        boolean prime[]=isPrime(n);
        for(int i=2;i<n;i++)
            if(prime[i]==true)
              c++;
        return c;   
    }
    // prime check by Seive of Erastosthenes
    private boolean[] isPrime(int n)
    {
        boolean prime[]=new boolean[n+1];
        Arrays.fill(prime,true);
        for(int i=2;i*i<=n;i++)
        {
            if(prime[i]==true)
            {
                for(int j=i*i;j<=n;j+=i)
                  prime[j]=false;
            }
        }
        return prime;
    }
}