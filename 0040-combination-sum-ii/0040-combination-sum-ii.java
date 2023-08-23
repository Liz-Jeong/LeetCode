class Solution {
    List<List<Integer>> res = new LinkedList<>();
    int[] nums;
    int target;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        nums = candidates;
        this.target = target;
        
        DFS(new LinkedList<>(), 0, 0);
        return res;
    }
    
    private void DFS(List<Integer> sub, int sum, int curIdx) {
        
        if(sum > target) return;
        if(sum == target) {
            res.add(new LinkedList<>(sub));
            return;
        }
        
        // [1, 1, 2, 5, 6, 7, 10], 8
        for(int i = curIdx; i < nums.length; i++) {
            if(curIdx < i && nums[i] == nums[i - 1]) continue;
            sub.add(nums[i]);
            DFS(sub, sum + nums[i], i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}