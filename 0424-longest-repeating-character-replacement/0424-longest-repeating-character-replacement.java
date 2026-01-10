class Solution {
    public int characterReplacement(String s, int k) {
    // Find the Longest substring with k different characters
       HashMap<Character,Integer> f=new HashMap<>();
       int l=0,r=0,max_len=0,maxf=0;
       while(r<s.length())
       {
         char chr=s.charAt(r); // character at right
         f.put(chr,f.getOrDefault(chr,0)+1);
         maxf=Math.max(maxf,f.get(chr));

        if((r-l+1)-maxf<=k)
           max_len=Math.max(max_len,r-l+1);
        else
        {
            char chl=s.charAt(l); // character at left
            f.put(chl,f.getOrDefault(chl,0)-1);
            if(f.get(chl)==0)
            f.remove(chl);
            l++;
        }
        r++;
       }
       return  max_len;
    }
}