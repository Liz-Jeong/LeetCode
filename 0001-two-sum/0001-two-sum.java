import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int arr[] = new int[2];
        int n = nums.length;
            
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = 0; j < nums.length; j++){
        //         if(i == j) continue;
        //         if(nums[i] + nums[j] == target){
        //             arr[0] = i;
        //             arr[1] = j;
        //             return arr;
        //         } 
        //     }    
        // }
        
        // improvement
        for(int i = 0; i < n; i++) {
            
            if(map.containsKey(target - nums[i])) {
                //return index from nums
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            }
            map.put(nums[i], i);
        }
        return arr;
    }
}