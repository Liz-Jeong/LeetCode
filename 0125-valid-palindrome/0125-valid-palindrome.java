class Solution {
    public boolean isPalindrome(String s) {
        
        String fixed_string = "";
        
        // remove all non-alphanumeric characters
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c) || Character.isLetter(c)) fixed_string += c;
        }
        
        // to lowercase
        fixed_string = fixed_string.toLowerCase();
        
        int a_pointer = 0;
        int b_pointer = fixed_string.length() - 1;
        
        // compare the character from the front and end
        while(a_pointer < b_pointer) {
            if(fixed_string.charAt(a_pointer) != fixed_string.charAt(b_pointer)) return false;
            a_pointer++;
            b_pointer--;
        }
        
        return true;
    }
}

// Alphanumeric characters -> Character(isLetter), Character(isDigit)
// 2 pointers from the beginning and the end