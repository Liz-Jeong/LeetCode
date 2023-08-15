class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // brute force - T : O(N2)
        // sort + two pointer - T: O(nlogn), S : O(1) 
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            if(map.getOrDefault(num, 0) != 0) return true;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return false;
        
//         HashSet<Integer> set = new HashSet<>();
        
//         for(int num : nums) {
//             if(set.contains(num)) return true;
//             set.add(num);
//         }
        
//         return false;
    }
}