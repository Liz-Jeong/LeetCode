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
}