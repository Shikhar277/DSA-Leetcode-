class Solution {
    public boolean completePrime(int num) {
        int l=(num+"").length();
        for(int i=1;i<l;i++)
        {
            int prefix=(int)(num / Math.pow(10,i));
            int suffix=(int)(num % Math.pow(10,i));
            if(!isPrime(prefix) || !isPrime(suffix))  // example:- 343535
            return false;
        }
            if(!isPrime(num))
            return false;

        return true;
    }
    public boolean isPrime(int num)
    {
        if(num==1)
        return false;
        else if(num==2)
        return true;
        else if(num%2==0)
        return false;

        for(int i=3;i*i<=num;i+=2)
          if(num%i==0)
            return false;

        return true;
    }
}