class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        char[] arr = answerKey.toCharArray();
        int mostFreq = 0, maxLen = 0, n = answerKey.length();
        
        Map<Character, Integer> map = new HashMap<>();
        
        // define window index
        int right = 0, left = 0;
        
        while(right < n) {
            // count mostFreq
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(arr[right]));
            
            // shrink window
            if((right - left + 1) - mostFreq > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
            
            // extend window
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        
        return maxLen;
    }
}