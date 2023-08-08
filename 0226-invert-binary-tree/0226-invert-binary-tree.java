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
    public TreeNode invertTree(TreeNode root) {
        
        // basic case
        if(root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        TreeNode leftTmp = new TreeNode();
        TreeNode rightTmp = new TreeNode();
        
        while(!queue.isEmpty()) {
            
            int level = queue.size();
            
            // search child nodes
            for(int i = 0; i < level; i++) {
                
                if(queue.peek() != null) {
                    leftTmp = queue.peek().left;
                    rightTmp = queue.peek().right;
                    
                    queue.peek().right = leftTmp;
                    queue.add(queue.peek().right);

                    queue.peek().left = rightTmp;
                    queue.add(queue.peek().left);
                }
                queue.poll();
                
            }
            
        }
        
        return root;
        
    }
}