class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxlen=0;
       HashSet<Character> set=new HashSet<>();
       int left=0;
       for(int right=0;right<s.length();right++)
       {
          while(!set.add(s.charAt(right)))
          set.remove(s.charAt(left++));

          if(right-left+1>maxlen)
          maxlen=right-left+1;
       }
        return maxlen;
    }
}