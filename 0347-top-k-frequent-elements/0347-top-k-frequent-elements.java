class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        
        // save each element appearance in a table
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // MinHeap with size k
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        // add key into the minHeap, but ordered by value
        for(int key : map.keySet()) {    // 1:3, 2:2, 3:1
            minHeap.add(key);
        }
        
        int index = 0;
        for(int i = 0; i < k; i++) {
            res[index++] = minHeap.poll();
        }
        
        return res;
    }
}