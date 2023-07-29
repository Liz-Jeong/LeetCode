class Solution {
    public int characterReplacement(String s, int k) {
        
        char[] arr = s.toCharArray();
        int left = 0, right = 0, n = s.length();
        
        //define table
        Map<Character, Integer> map = new HashMap<>();
        
        //define maxLen and mostFreq
        int mostFreq = 0, maxLen = 0;
            
        //implement sliding window
        //find longest repeating chararter replacement
        while(right < n) {
            
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(arr[right]));
            
            //shrink the window if we need to replace more than k char
            if ((right - left + 1) - mostFreq > k) {    //** maxLen - mostFreq <= k
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
            
        }
        
        return maxLen;
    }
}