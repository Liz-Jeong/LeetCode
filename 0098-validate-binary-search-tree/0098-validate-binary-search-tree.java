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
    public boolean isValidBST(TreeNode root) {
        
        long max = Long.MAX_VALUE, min = Long.MIN_VALUE;
        
        // compare value within range
        return compareValue(root, min, max);
    }
    
    private boolean compareValue(TreeNode node, long left, long right) {
        
        // base case
        if(node == null) return true;
        
        // if not BST, return false
        if(node.val <= left || node.val >= right) return false;
        
        return compareValue(node.left, left, node.val) && compareValue(node.right, node.val, right);
    }
}