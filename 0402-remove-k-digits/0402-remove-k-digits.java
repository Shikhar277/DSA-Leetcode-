class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k)
        return "0";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:st)
        sb.append(ch);
        

        while(sb.length()>0 && sb.charAt(0)=='0')
        sb.deleteCharAt(0);

        if(sb.length()==0)
        return "0";
        else
        return sb.toString();
    }
}