class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    // set minVal for O(1) time complexity of getMin()
    int minVal;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);

        if(minStack.isEmpty()) {
            minVal = Math.min(Integer.MAX_VALUE, val);
        } else {
            minVal = Math.min(minStack.peek(), val);
        }
        minStack.add(minVal);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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