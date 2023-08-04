class Solution {
    public int findKthLargest(int[] nums, int k) {
        // with sorting
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Comparator.reverseOrder());
        
        return arr[k - 1];
    }
}