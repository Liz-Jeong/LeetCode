class Solution {
    public int search(int[] nums, int target) {
        
        // log n, sorted -> unsorted array
        // see if target is in the range of ascending order part
        
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(target == nums[mid]) return mid;
            
            if(nums[mid] > nums[right]){
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }   
            } else {
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            
        }
        
        if(target == nums[left]) return left;
        if(target == nums[right]) return right;
        return -1;
        
//         mid > right -> left: sorted, right: unsorted
//             see if target is in sorted part -> X -> search unsorted part
                
//             target > right -> left search
//             target <= right -> right
            
//         mid < right -> left: unsorted, right: sorted
//             target > mid -> right
//             target <= mid -> left
            
    }
}