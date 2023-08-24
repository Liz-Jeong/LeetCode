class Solution {
    
    HashMap<Character, String> phone = new HashMap<>();
    
    List<String> res = new ArrayList<>();
    char[] input;
    
    public List<String> letterCombinations(String digits) {
        
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");
        
        input = digits.toCharArray();
        if(input.length == 0) return res;
        
        DFS("", 0);
        return res;
    }
    
    private void DFS(String str, int index) {
        
        if(str.length() == input.length) {
            res.add(new String(str));
            return;
        }
        
        String nums = phone.get(input[index]);
        char[] list = nums.toCharArray();
        int strLen = phone.get(input[index]).length(); //abc
        
        for(int i = 0; i < strLen; i++) {
            str += list[i];
            DFS(str, index + 1);
            str = str.substring(0, str.length() - 1);
        }
    }
}