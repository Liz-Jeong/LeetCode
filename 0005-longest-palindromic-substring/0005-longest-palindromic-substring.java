class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        int start = 0, end = 0;
        
        for(int i = 0; i < n; i++) {
            // separate the cases - odd/even
            int len1 = isPalindrome(s, i, i);
            int len2 = isPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            // when find new boundary
            if(len > end - start) {
                // define start, end
                // mid index + length -> find start, end index
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    public int isPalindrome(String s, int start, int end) {
        
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            // if(s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            // }
        }
        // except last characters at the ends
        return end - start - 1;
        
    }
}