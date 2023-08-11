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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         List<List<Integer>> res = new LinkedList<List<Integer>>();
        
//         if(root == null) return res;
        
//         queue.offer(root);
        
//         while(!queue.isEmpty()) {
//             int level = queue.size();   // define level before queue increment
//             List<Integer> subList = new LinkedList<Integer>();
            
//             // add nodes(on the same level) to the queue
//             for(int i = 0; i < level; i++) {
//                 if(queue.peek().left != null) queue.offer(queue.peek().left);
//                 if(queue.peek().right != null) queue.offer(queue.peek().right);
//                 subList.add(queue.poll().val);
//             }
            
//             res.add(subList);
//         }
        
//         return res;
        
        //try second
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        //base case
        if(root == null) return res;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int len = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            
            for(int i = 0; i < len; i++) {
                // add every child at the same level
                TreeNode node = queue.poll();
                subList.add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            res.add(subList);
        }
        
        return res;
    }
}