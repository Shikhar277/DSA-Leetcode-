class Solution {
    public String removeOuterParentheses(String s){
        Stack<Character> st=new Stack<>();
        int idx=-1;// current index
        int start=0;// starting index;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
              st.push('(');
              idx++;
            }
            else
            {
              st.pop();
              idx++;
            }
            if(st.isEmpty()){
               ans.append(s.substring(start+1,idx));
               start=idx+1;
            }
        }
        return ans.toString();
    }
}