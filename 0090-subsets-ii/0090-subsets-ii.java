class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    int[] arr;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        arr = nums;
        Arrays.sort(arr);
        DFS(new LinkedList<>(), 0);
        return res;
        
        // [1,2,3,2,3]
        // [1,2,2,3,3]
        
        // [1,2,2] -> [1,2] [1,2] X
    }
    
    private void DFS(List sub, int curIdx) {
        
        res.add(new LinkedList<>(sub));
        
        for(int i = curIdx; i < arr.length; i++) {
            
            // [i]
            //1[0] -> 2[1] : i == curIdx
            //1[0] -> 2[1] -> 2[2] : i == curIdx
            //1[0] -> (2[1]) -> 2[2] : i != curIdx(i = 2, curIdx = 1)
            
            if(i != curIdx && arr[i] == arr[i - 1]) continue;
            
            sub.add(arr[i]);
            DFS(sub, i + 1);
            sub.remove(sub.size() - 1);
        }
        
    }
}