class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int num:asteroids)
        {
            if(num>0)
            st.push(num);
            else
            { 
               num=Math.abs(num);
               while(!st.isEmpty() && st.peek()<num && st.peek()>0)
               st.pop();
               if(!st.isEmpty() && st.peek()==num){
               st.pop();
               continue;
               }
               if(st.isEmpty() || st.peek()<0)
               st.push(-num);
            }           
        }
        int ans[]=new int[st.size()]; int i=0;
        for(int num:st)
        ans[i++]=num;

        return ans;
    }
}