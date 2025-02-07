class MinStack {

    int min=Integer.MAX_VALUE;
    static class pair{
        int a,b;

        // public pair(int a,int b)
        // {
        //     this.a=a;
        //     this.b=b;
        // }
    }
    Stack<pair> s;
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int val) {
        pair p=new pair();
        p.a=val;
        if(val<min)
        min=val;
        p.b=min;

        s.push(p);
    }
    
    public void pop() {
        s.pop();

        if (!s.isEmpty()) {
            min = s.peek().b;
        } else {
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return s.peek().a;
    }
    
    public int getMin() {
        return s.peek().b;
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
