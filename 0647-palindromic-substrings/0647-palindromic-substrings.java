class Solution {
    
    // Palindromic Substrings
    // 1. if Palindromic Substrings or not
    // 2. given string, find number of Palindromic Substrings
    //     -> separate case of odd/even string length 
    
    int count = 0;
    
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        // Palindrom -> set the cases (odd, even)
        for(int i = 0; i < s.length(); i++) {
            isPelindrome(s, i, i);      // odd length pelindromic substring
            isPelindrome(s, i, i + 1);  // even length pelindromic substring
        }
        
        return count;
        
    }
    
    public void isPelindrome(String s, int start, int end) {
        // check the pelindrome substring
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;    // index moved to left
            end++;      // index moved to right
        }
    }
}