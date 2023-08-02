class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //add incoming edges to the table
        int[] table = new int[numCourses];
        for(int[] courses : prerequisites) {    // [[1,0],[0,2],[3,1],[3,0]]
            int currCourse = courses[0];
            table[currCourse]++;
        }
        
        Set<Integer> set = new HashSet<>();
        
        //find the element that has no incoming edges
        for(int i = 0; i < table.length; i++) {
            if(table[i] == 0) set.add(i);
        }
        
        //If the set if empty that means we have cyclic graph
        if(set.isEmpty()) return false;
        
        while(!set.isEmpty()) {
            Iterator<Integer> iter = set.iterator();
            Integer element = iter.next();
            
            // remove edges that element has
            for(int course = 0; course < prerequisites.length; course++) {
                
                // check to see if preQ == element
                int preQ = prerequisites[course][1];
                
                // We found the connection
                if(preQ == element) {
                    int currCourse = prerequisites[course][0];
                    
                    // remove the incoming edges of this current course
                    table[currCourse]--;
                    if(table[currCourse] == 0) set.add(currCourse);
                } 
            }
            
            // remove the node without any edges
            set.remove(element);
        }
        
        //check if there is cycle
        for(int course : table){
            if(course > 0) return false;
        }
        
        return true;
    }
}