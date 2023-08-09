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
    // 1. have to traverse all the nodes
    //boolean res = true;
    
    // 2. return false right away
    final int UNBALANCED = -1;
    
    public boolean isBalanced(TreeNode root) {
        // Balanced Tree : height difference between left and right of every node no bigger than 1.
        
        // base case
        if(root == null) return true;
        return dfs(root) != UNBALANCED;
        
        //return res;
    }
    
    private int dfs(TreeNode root) {
        
        int left = 0, right = 0;
        
        // Left Subtree DFS
        if(root.left != null) {
            left = dfs(root.left);
        }
        if(left == UNBALANCED) return UNBALANCED;
        
        // Right Subtree DFS
        if(root.right != null) {
            right = dfs(root.right);
        }
        if(right == UNBALANCED) return UNBALANCED;
        
        // check if it is not height-balanced tree.
        // if(Math.abs(left - right) > 1) {
        //     res = false;
        // }
        // return Math.max(left, right) + 1;
        
        if(Math.abs(left - right) <= 1) return Math.max(left, right) + 1;
        return UNBALANCED;
    }
}