class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        
        // put count into map
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        // order by descending
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b).compareTo(map.get(a));
            }
        });
        
        int counter = 0;
        
        for(Integer key : keySet) {
        
            while(counter < k) {
                result[counter] = keySet.get(counter);
                counter++;
            }
        }
        
        return result;
    }
}