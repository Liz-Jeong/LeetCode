class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        //Arrays.sort(nums);

        // define set 
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for(int num : nums) {
            int currLen = 1;
            int preVal = num - 1;
            int nextVal = num + 1;

            // find smaller value
            while(set.contains(preVal)) {
                currLen++;
                set.remove(preVal--);
            }

            // find bigger value
            while(set.contains(nextVal)) {
                currLen++;
                set.remove(nextVal++);
            }
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;

        // 슬라이딩 윈도우는 일정한 조건의 서브스트링을 추출하거나 동일한 문자 연속 찾아낼 때 사용
        // extend 후 윈도우 내에서 조건이 불일치하는 경우 shrink하는 형태
        // 0 1 1 2
        // ^        // start index that meets the requirement
        //   ^
    }
}