class Solution {
    public int maxProduct(int[] nums) {
        
        int currMax = nums[0], currMin = nums[0];
        int maxSoFar = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            // save currMax before update currMax
            int tempMax = currMax;
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(tempMax * nums[i], currMin * nums[i]));
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        // to be fixed.. in case of minus * minus
        return maxSoFar;
    }
}