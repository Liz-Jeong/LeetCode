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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res =  new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int len = queue.size(); // number of nodes at the same depth
            TreeNode rightSide = null;

            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                rightSide = node;

                if(node != null) {
                    //if(i == len - 1) res.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }

            }

            if(rightSide != null) res.add(rightSide.val);
        }
        
        return res;
    }
}