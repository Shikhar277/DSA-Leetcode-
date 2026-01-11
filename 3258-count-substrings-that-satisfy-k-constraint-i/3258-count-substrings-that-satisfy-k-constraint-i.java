class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int l=0,r=0; int zero=0,one=0;
        int count=0;
        while(r<n)
        {
            char ch=s.charAt(r);
            if(ch=='0') zero++;
            else if(ch=='1') one++;
            
            while(zero>k && one>k)
            {
              char c=s.charAt(l);
              if(c=='0') zero--;
              else if(c=='1') one--;
              l++; 
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}