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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Recursive
        // base case
//         if(p == null && q == null) return true;
//         if(p == null || q == null) return false;
//         if(p.val != q.val) return false;
        
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
        return DFS(p, q);
    }
    
    private boolean DFS(TreeNode p, TreeNode q) {
        // 2. DFS
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        
        return DFS(p.left, q.left) && DFS(p.right, q.right);
    }
}