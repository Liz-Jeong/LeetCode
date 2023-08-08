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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null) return true;
        
        // recursive
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode root) {
        
        int left = 0, right = 0;
        
        if(root.left != null) {
            left = dfs(root.left);
        }
        if(root.right != null) {
            right = dfs(root.right);
        }
        // check if it is not height-balanced tree.
        if(Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
        
    }
}