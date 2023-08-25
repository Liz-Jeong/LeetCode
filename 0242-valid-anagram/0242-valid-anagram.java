class Solution {
    public boolean isAnagram(String s, String t) {
        
        // 1. Sorting -> time complexity of O(n log n) due to the sorting operation
        // char[] first = s.toCharArray();
        // char[] second = t.toCharArray();
        
        // Arrays.sort(first);
        // Arrays.sort(second);
        
        // if(Arrays.equals(first, second)) {
        //     return true;
        // }else {
        //     return false;
        // }
        
        //2. Hash Table -> time complexity of O(n)
        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        // check if all characters have zero frequency
        for(int val : count.values()) {
            if(val != 0) return false;
        }

        return true;
    }
}