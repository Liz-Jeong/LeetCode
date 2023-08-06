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
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;
        
        // default 1
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            
            int level = queue.size();
            
            // find left, right node
            for(int i = 0; i < level; i++) {
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                
                queue.poll();   // remove upper node    
            }
            
            if(!queue.isEmpty()) depth++;
            
        }
        
        return depth;
        
    }
}