class Solution {
    public int findMin(int[] nums) {
        
//         int[] sorted = Arrays.copyOf(nums, nums.length);
//         Arrays.sort(sorted);
        
//         int min = 0;
        
//         for(int i = 0; i < nums.length; i++) {
//             if(nums[i] == sorted[0]) min = nums[i];
//         }
        
//         return min;
        
        // Inprovement: time complexity O(log n)
        // 1. sorted array.. binary search
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = (right - left) / 2 + left;
            
             // 2. find unsorted part (left vs right)
            if(nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        // 3. two elements left
        return Math.min(nums[left], nums[right]);
        
        
    }
}