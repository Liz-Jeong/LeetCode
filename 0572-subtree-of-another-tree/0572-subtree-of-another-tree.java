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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case - check if both root and subRoot exist
        if(subRoot == null) return true;
        if(root == null) return false;
        
        // check if the subtrees are same
        if(DFS(root, subRoot)) {
            return true;
        }
        
        // find root which is same as subRoot
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean DFS(TreeNode tree, TreeNode subtree) {
        if(tree == null && subtree == null) return true;
        if(tree == null || subtree == null) return false;
        
        // compare two nodes
        if(tree.val != subtree.val) return false;
        
        // if the values are same, continue to traverse nodes in the next level
        return DFS(tree.left, subtree.left) && DFS(tree.right, subtree.right); 
    }
}