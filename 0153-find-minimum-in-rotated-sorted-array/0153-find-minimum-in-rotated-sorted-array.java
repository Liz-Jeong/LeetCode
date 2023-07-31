class Solution {
    public int findMin(int[] nums) {
        
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        
        int min = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == sorted[0]) min = nums[i];
        }
        
        return min;
        
    }
}