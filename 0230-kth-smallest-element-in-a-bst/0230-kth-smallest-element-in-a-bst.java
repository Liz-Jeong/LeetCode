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
    public int kthSmallest(TreeNode root, int k) {
        
        // [recursive] vs *[in order iterative]
        // Time Complexity : BEST CASE O(log(n)) ~ WORST CASE O(N) of biased tree
        // Space Complexity : O(log n), O(H)
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        int order = 0;
        
        // curr != null : to start from root
        // !stack.isEmpty() : still have nodes to iterate
        while(curr != null || !stack.isEmpty()) {

            // add into stack from the smallest value
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            
            // no more small value
            curr = stack.pop();

            // nth smallest value
            if(++order == k) return curr.val;

            curr = curr.right;
        }

        return root.val;
    }
}