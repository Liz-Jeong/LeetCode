class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 1. with sorting
//         Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//         Arrays.sort(arr, Comparator.reverseOrder());
        
//         return arr[k - 1];
        
        // 2. priority queue
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums) {
            minHeap.add(num);
            
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}