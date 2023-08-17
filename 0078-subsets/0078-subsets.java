class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    int[] arr;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        arr = nums;
        DFS(new LinkedList<>(), 0);
        return res;
        
    }
    
    private void DFS(List<Integer> subset, int curIdx) {
        
        res.add(new LinkedList<>(subset));
        
        // come back when exhausted all the options
        for(int i = curIdx; i < arr.length; i++) {
            subset.add(arr[i]);
            DFS(subset, i + 1);    // except for duplication 
            subset.remove(subset.size() - 1);
        }
        
        // [[],[1],[1,2],[1,2,3],[1,3] ,[2],[2,3] ,[3]]
    }
}