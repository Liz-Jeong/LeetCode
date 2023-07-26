class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> res = new ArrayList();
        boolean[] inDegree = new boolean[n];    // initialize -> default false

        for(List<Integer> edge : edges) {
            inDegree[edge.get(1)] = true;
        }

        for(int vertex = 0; vertex < n; vertex++) {
            if(!inDegree[vertex]) res.add(vertex);
        }

        return res;
    }
}