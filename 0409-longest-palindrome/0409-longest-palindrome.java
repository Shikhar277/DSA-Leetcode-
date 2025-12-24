class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
           map.put(ch,map.getOrDefault(ch,0)+1);

        int len=0;
        boolean f=false;
        for(char ch:map.keySet())
        {
           if(map.get(ch)%2==0)
             len+=map.get(ch);
           if(map.get(ch)%2!=0){
             len+=map.get(ch)-1;
             f=true;
           }
        }
        if(f) 
        return len+1; 
        else 
        return len;
    }
}