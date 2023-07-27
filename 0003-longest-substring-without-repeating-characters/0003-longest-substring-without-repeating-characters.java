class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] arr = s.toCharArray();
        
        int max = 0;
        String str = "";
        
        for(int i = 0; i < arr.length; i++) {
            
            str = "";
            
            for(int j = i; j < arr.length; j++) {
                
                if(str.indexOf(arr[j]) != -1) break;
                
                str += arr[j];
                
                if(str.length() > max) max = str.length();
            } 
        }
        
        return max;
        
        
    }
}