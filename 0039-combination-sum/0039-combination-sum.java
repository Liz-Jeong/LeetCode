class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    int[] nums;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        nums = candidates;
        this.target = target;
        
        DFS(new LinkedList<>(), 0, 0);
        return res;
    }
    
    private void DFS(List<Integer> sub, int sum, int curIdx) {
        
        // using 'sum' instead of 'target' to enhance readability
        if(sum > target) return;
        if(sum == target) {
            res.add(new LinkedList<>(sub));
            return;
        }
        
        // using recurrent tree
        for(int i = curIdx; i < nums.length; i++) {
            sub.add(nums[i]);
            DFS(sub, sum + nums[i], i);
            sub.remove(sub.size() - 1);
        }
        
        
    }
}