/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // global var
    //int counter = 0;
    
    public int goodNodes(TreeNode root) {
        
        // root node is always a good node
        return DFS(root, root.val);
    }
    
    private int DFS(TreeNode node, int max) {
        
        // base case
        if(node == null) return 0;
        
        int counter = 0;
        
        // add count if node's val is bigger than max 
        if(node.val >= max) {
            max = node.val;
            counter++;
        }
        
        // traverse subtree
        counter += DFS(node.left, max);
        counter += DFS(node.right, max);
        
        // return good nodes
        return counter;
    }
    
    // *Time complexity : O(N)
    // During DFS traversal of the entire tree, we visit each node once.
    // The time complexity is proportional to the number of nodes in the tree, which is O(N).
    
    // *Space complexity : O(log N == H), Height of the binary tree
    // This is recursive implementation
    // The space complexity is determined by the maximum number of recursive calls on the call stack at any given time.
    // Assuming that it's balanced tree, the height is logarithmic (H = log N)
    
}