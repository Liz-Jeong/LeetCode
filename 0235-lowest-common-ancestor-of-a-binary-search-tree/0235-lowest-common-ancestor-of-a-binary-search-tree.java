/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // binary search tree - O(log n), O(1)
        
        // 1. recursive
        // p == root || q == root => LCA : root
        // if(root.val == p.val || root.val == q.val) return root;
        // if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        // if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        // return root;
        
        // 2. O(1) space complexity
        while(root != null) {
            int cur = root.val;
            if(cur > p.val && cur > q.val) root = root.left;
            else if(cur < p.val && cur < q.val) root = root.right;
            else break;
        }
        return root;
    }
}