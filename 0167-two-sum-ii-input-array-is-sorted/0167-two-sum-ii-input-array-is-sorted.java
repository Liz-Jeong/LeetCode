class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            
            if(map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
            }
                
            map.put(target - numbers[i], i);    // pair value, index
            // 7, 0
            // 2, 1
            // -2, 2
            // -6, 3
        }
        
        return res;
    }
}