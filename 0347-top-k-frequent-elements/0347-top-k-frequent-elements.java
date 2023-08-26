class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        
        // save each element appearance in a table
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // MinHeap with size k
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        // add key into the minHeap, but ordered by value
        for(int key : map.keySet()) {    // 1:3, 2:2, 3:1
            minHeap.add(key);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        int index = 0;
        while(!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        
        return res;
    }
}