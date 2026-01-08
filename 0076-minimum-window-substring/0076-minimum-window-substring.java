class Solution {
    public String minWindow(String s, String t) {
        int arr[]=new int[70]; // just random to keep in all lower and upper cases
        for(char ch:t.toCharArray())
           arr[ch-'A']++;
        int l=0,r=0;int count=0;
        int startidx=0,minLen=Integer.MAX_VALUE;
        while(r<s.length())
        {
            if(arr[s.charAt(r)-'A']>0)
               count++;
            arr[s.charAt(r)-'A']--;
            while(count==t.length())
            {
                if(r-l+1<minLen){
                  startidx=l;
                  minLen=r-l+1;
                }

                arr[s.charAt(l)-'A']++;
                if(arr[s.charAt(l)-'A']>0)
                  count--;
                l++;
            }
            r++;
        }
        return (startidx==0 && minLen==Integer.MAX_VALUE) ? "" : s.substring(startidx,startidx+minLen);
    }
}