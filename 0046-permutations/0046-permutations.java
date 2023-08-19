class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    int[] arr;
    
    public List<List<Integer>> permute(int[] nums) {
        arr = nums;    
        DFS(new LinkedList<>());
        return res;
    }
    
    private void DFS(List<Integer> subset) {
        
        if(subset.size() == arr.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(subset.contains(arr[i])) continue;   // duplicated value is not acceptable
            subset.add(arr[i]);
            DFS(subset);
            subset.remove(subset.size() - 1);
        }
        
        // [1,2,3]
        
        // [1]
        // [1, 2] [1, 3]
        // [1, 2, 3] [1, 3, 2]
        
        // [2]
        // [2, 1] [2, 3]
        // [2, 1, 3] [2, 3, 1]
        
    }
}