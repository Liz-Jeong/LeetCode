class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // save each element's appearance in a table
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        /* My Solution. keySet into List -> reverse sort -> save into Array for k
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        // order by descending
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b).compareTo(map.get(a));
            }
        });
        
        int counter = 0;
        int[] result = new int[k];
        
        for(Integer key : keySet) {
            while(counter < k) {
                result[counter] = keySet.get(counter);
                counter++;
            }
        }
        
        return result;
        */
        
        // solution2. define min heap with size k
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        //top k frequent element
        for(int num : map.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[minHeap.size()];
        int index = 0;
        while(!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        return res;
    }
}