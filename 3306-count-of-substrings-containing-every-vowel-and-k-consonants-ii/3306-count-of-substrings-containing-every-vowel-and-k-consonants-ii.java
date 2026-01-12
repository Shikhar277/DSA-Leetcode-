class Solution {
    public long countOfSubstrings(String word, int k) {
         if(k==0)
        return substrings(word,k);
   
        return substrings(word,k)-substrings(word,k-1);// atmost k -atmost k-1
    }
    public long substrings(String word,int k)// atmost k consonants + atleast all vowels covered
    {
       long a=0,e=0,i=0,o=0,u=0;
       long La=-1,Le=-1,Li=-1,Lo=-1,Lu=-1; // last seen indices
       long count_k=0;
       int l=0,r=0;
       long count_substrings=0;
       while(r<word.length())
       {
         char ch=word.charAt(r);
         if(ch=='a'){ a++; La = r; }
         else if(ch=='e'){ e++; Le = r; }
         else if(ch=='i'){ i++; Li = r; }
         else if(ch=='o'){ o++; Lo = r; }
         else if(ch=='u'){ u++; Lu = r; }
         else count_k++;

         while(count_k>k)// condition only on k not vowels to shrink the window(IMP)
         {
            char c=word.charAt(l);
            if(c=='a') a--;
            else if(c=='e') e--;
            else if(c=='i') i--;
            else if(c=='o') o--;
            else if(c=='u') u--;
            else count_k--; 
            l++;       
         }
         if(a>=1 && e>=1 && i>=1 && o>=1 && u>=1){
           long minLastSeen = Math.min(La, Math.min(Le, Math.min(Li, Math.min(Lo, Lu))));
           count_substrings += (minLastSeen - l + 1);
         }
           r++;
        }
        return count_substrings; 
    }
}