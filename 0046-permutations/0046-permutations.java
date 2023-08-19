class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    int[] arr;
    
    public List<List<Integer>> permute(int[] nums) {
        
        // 2. the other way to solve this problem : use List<Integer> decision tree
        List<Integer> dt = new LinkedList<>();
        for(int num : nums) {
            dt.add(num);    
        }
        DFS(new LinkedList<>(), dt);
        return res;
        
        // 1. DFS
        // arr = nums;    
        // DFS(new LinkedList<>());
        // return res;
    }
    
    private void DFS(List<Integer> permutation, List<Integer> dt) {
        
        if(dt.size() == 0) {
            res.add(permutation);
            return;
        }
        
        for(Integer num : dt) {
            List<Integer> tempP = new LinkedList<>(permutation);
            List<Integer> tempDt = new LinkedList<>(dt);
            tempP.add(num);     // [1]
            tempDt.remove(num);
            DFS(tempP, tempDt); // [2, 3]
        }
        
//         if(permutation.size() == arr.length) {
//             res.add(new ArrayList<>(permutation));
//             return;
//         }

//         for(int i = 0; i < arr.length; i++) {
//             if(permutation.contains(arr[i])) continue;   // duplicated value is not acceptable
//             permutation.add(arr[i]);
//             DFS(permutation);
//             permutation.remove(permutation.size() - 1);
//         }
        
    }
}