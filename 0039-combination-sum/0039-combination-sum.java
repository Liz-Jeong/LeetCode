class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    int[] nums;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        nums = candidates;
        DFS(new LinkedList<>(), target, 0);
        return res;
    }
    
    private void DFS(List<Integer> sub, int target, int curIdx) {
        
        // using recurrent tree
        for(int i = curIdx; i < nums.length; i++) {
            
            // return sub : target - val = 0
            if(target - nums[i] == 0) {
                sub.add(nums[i]);
                res.add(new LinkedList<>(sub));
                sub.remove(sub.size() - 1);
            }
            
            // keep traversing : target - val > 0
            if(target - nums[i] > 0) {
                sub.add(nums[i]);
                DFS(sub, target - nums[i], i);
                sub.remove(sub.size() - 1);
            }
            
            curIdx++;
            
        }
        
        
    }
}