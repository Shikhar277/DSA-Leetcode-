class Solution {
    public int numberOfSubstrings(String s) {
       int a=-1,b=-1,c=-1; // count the substrings backward 
       int count=0;
       for(int i=0;i<s.length();i++)
       {
         char ch=s.charAt(i);
         if(ch=='a') a=i;
         else if(ch=='b') b=i;
         else c=i;

         if(a!=-1 && b!=-1 && c!=-1)
           count+=Math.min(a, Math.min(b, c)) + 1;
       }
       return count;
    }
}
// At abcabc 
/*
   last if condition is true when i=2 we can  at that point sub arrays before abc including it are 0+1=1
   then before bca we have 2 similarly including it
   so on... before cab 3
*/