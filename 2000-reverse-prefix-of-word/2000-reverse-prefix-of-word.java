class Solution {
    public String reversePrefix(String word, char ch) {
        // USE STACK FOR REVERSAL
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int first=word.indexOf(ch);
        for(int i=0;i<=first;i++)
        {
            st.push(word.charAt(i));
        }
        while(!st.isEmpty())
        sb.append(st.pop());
        for(int i=first+1;i<word.length();i++)
        {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}