import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int output = 0;
        int length = s.length();
        boolean skip = false;
        
        for(int i = 0; i < length; i++){
            
            if(output > 3999) break;
            
            if(skip){
                skip = false;
                continue;
            }
            
            if(s.charAt(i) == 'I'){
                if((i + 1) < length && s.charAt(i + 1) == 'V'){
                    output += 4;
                    skip = true;
                }else if((i + 1) < length && s.charAt(i + 1) == 'X'){
                    output += 9;
                    skip = true;
                }else{
                    output += 1;   
                }
            }else if (s.charAt(i) == 'V'){
                output += 5;
            }else if (s.charAt(i) == 'X'){
                if((i + 1) < length && s.charAt(i + 1) == 'L'){
                    output += 40;
                    skip = true;
                }else if((i + 1) < length && s.charAt(i + 1) == 'C'){
                    output += 90;
                    skip = true;
                }else{
                    output += 10;
                }
            }else if (s.charAt(i) == 'L'){
                output += 50;
            }else if (s.charAt(i) == 'C'){
                if((i + 1) < length && s.charAt(i + 1) == 'D'){
                    output += 400;
                    skip = true;
                }else if((i + 1) < length && s.charAt(i + 1) == 'M'){
                    output += 900;
                    skip = true;
                }else{
                    output += 100;
                }
            }else if (s.charAt(i) == 'D'){
                output += 500;
            }else if (s.charAt(i) == 'M'){
                output += 1000;
            }
              
            
        }
        
        return output;
    }
}