class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        int len = temperatures.length;
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int topIndex = stack.pop();
                int wait = i - topIndex;
                res[topIndex] = wait;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int topIndex = stack.pop();
            res[topIndex] = 0;
        }
        
        return res;

        // Brute search -> Time Complexity : O(n^2)
        // Improvement -> Stack with index
    }
}