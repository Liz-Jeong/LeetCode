class Solution {
    public int lengthOfLongestSubstring(String s) {
        // stack, contains -> pop, maxLen
        
        // base case
        char[] arr = s.toCharArray();
        int n = arr.length;
        if(n < 2) return n;
        
        // define poiners
        int left = 0, right = 0;
        
        // define table
        Map<Character, Integer> map = new HashMap<>();
        
        // define maxLen
        int maxLen = 0;
        
        // find longest substring
        while(right < n) {
            // check if we meet the condition
            while(map.getOrDefault(arr[right], 0) > 0) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
            
            // add current element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            // update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
            
            // move the right poiner
            right++;
        }
        
        
        // return maxLen
        return maxLen;
        
    }
}