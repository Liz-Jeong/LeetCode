import java.util.Map;
import java.util.HashMap;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> countStone = new HashMap<>();
        
        for(char stone : stones.toCharArray()) {    // String -> toCharArray()
            int count = countStone.getOrDefault(stone, 0) + 1;
            countStone.put(stone, count);
        }
        
        int count = 0;
        for(char jewel : jewels.toCharArray()) {     // String -> toCharArray()
            count += countStone.getOrDefault(jewel, 0);
        }
        
        return count;
        
    }
}