class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    // Using Sliding Window
       int wrdlen=words[0].length();
       HashMap<String,Integer> w=new HashMap<>();
       List<Integer> ans=new ArrayList<>();

       for(String str:words)
       w.put(str,w.getOrDefault(str,0)+1);

       for(int i=0;i<wrdlen;i++)
       {
         int l=i;int r=i;
         int count=0;
         HashMap<String,Integer> check=new HashMap<>();
         while(r<=s.length()-wrdlen)
         {
            String str=s.substring(r,r+wrdlen);
            if(w.containsKey(str))
            {
               check.put(str,check.getOrDefault(str,0)+1);
               count++;

               while(check.get(str)>w.get(str))
               {
                  String start=s.substring(l,l+wrdlen);
                  check.put(start,check.get(start)-1);
                  l+=wrdlen;
                  count--;
               }
               if(count==words.length)
                  ans.add(l);
            }
            else
            {
               count=0;
               l=r+wrdlen;
               check.clear();
            }
            r+=wrdlen;
         }
       }
       return ans;
    }
}