class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //2. Improvement Time complexity : O(m * n * 26)
        // Keep a table to group all the anagrams together
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            // Sort the string to get the key
            String key = generateKey(str);
            
            // Add the current string to the table
            if(!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            List<String> list = map.get(key);
            list.add(str);
        }
        // convert map to list
        return new ArrayList<>(map.values());
        
        // 1. Arrays.sort -> Time complexity : O(m * nlogn).. m is length of strs, n is length of single string
        // Create List sorted by Key in Map
//         Map<String, List<String>> map = new HashMap<>();

//         for(String str : strs) {
//             char[] sorted = str.toCharArray();
//             Arrays.sort(sorted);

//             List<String> newList = new ArrayList<>();
//             List<String> list = map.getOrDefault(String.valueOf(sorted), newList);
//             list.add(str);

//             // put the original INPUT into map
//             map.put(String.valueOf(sorted), list);
//         }

//         // Map To List
//         List<List<String>> result = new ArrayList<>();

//         for(String key : map.keySet()) {
//             result.add(map.get(key));
//         }
        
//         return result;
    }
    
    private String generateKey(String str) {
        // create static array
        int[] count = new int[26];
        char[] arr = str.toCharArray();
        
        // O(n) to convert to array {a: 12, b: 0 ..}
        for(char curChar : arr) {
            count[curChar - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        // O(26) to convert to "12#0#.."
        for(int num : count) {
            sb.append(num);
            sb.append("#");
        }
        
        return sb.toString();
    }
    
}