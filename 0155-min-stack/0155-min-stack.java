class MinStack {
    Stack<int[]> st; // stores pair [val,min seen till now]
    int new_min;
    public MinStack() {
        st=new Stack<>();
        new_min=Integer.MAX_VALUE;
    }
    
    public void push(int val){
        if(st.isEmpty())
        {
          new_min=val;
          st.push(new int[]{val,new_min});
        }
        else
        {
            int prev_pair[]=st.peek();
            new_min=Math.min(val,prev_pair[1]);
            st.push(new int[]{val,new_min});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */