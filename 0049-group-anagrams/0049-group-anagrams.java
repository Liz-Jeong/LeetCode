class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Create List sorted by Key in Map
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);

            List<String> newList = new ArrayList<>();
            List<String> list = map.getOrDefault(String.valueOf(sorted), newList);
            list.add(str);

            // put the original INPUT into map
            map.put(String.valueOf(sorted), list);
        }

        // Map To List
        List<List<String>> result = new ArrayList<>();

        for(String key : map.keySet()) {
            result.add(map.get(key));
        }
        
        return result;
    }
}