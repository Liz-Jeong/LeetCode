class Solution {
    
    HashMap<Character, String> phone = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    List<String> res = new ArrayList<>();
    char[] input;
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0) return res;
        this.input = digits.toCharArray();
        
        // make improvement using StringBuilder
        DFS(new StringBuilder(), 0);
        //DFS("", 0);
        return res;
    }
    
    private void DFS(StringBuilder sb, int index) {
        //Base Case
        if(index == input.length) {
            res.add(sb.toString());
            return;
        }
        
        String nums = phone.get(input[index]);
        for(char cur : nums.toCharArray()) {
            sb.append(cur);
            DFS(sb, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
    
//     private void DFS(String str, int index) {
        
//         if(str.length() == input.length) {
//             res.add(new String(str));
//             return;
//         }
        
//         String nums = phone.get(input[index]);
//         char[] list = nums.toCharArray();
//         int strLen = phone.get(input[index]).length(); //abc
        
//         for(int i = 0; i < strLen; i++) {
//             str += list[i];
//             DFS(str, index + 1);
//             str = str.substring(0, str.length() - 1);
//         }
//     }
}