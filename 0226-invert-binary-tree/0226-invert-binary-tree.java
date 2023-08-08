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
        
        // solution1
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         TreeNode tmp = new TreeNode();
        
//         while(!queue.isEmpty()) {
//             int level = queue.size();
//             // search child nodes
//             for(int i = 0; i < level; i++) {
                
//                 if(queue.peek() != null) {
//                     tmp = queue.peek().left;
                    
//                     queue.peek().left = queue.peek().right;
//                     queue.add(queue.peek().left);
                    
//                     queue.peek().right = tmp;
//                     queue.add(queue.peek().right);
//                 }
                
//                 queue.poll();
//             }
            
//         }
        
        //solution2. code improvement(Recursive)
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}