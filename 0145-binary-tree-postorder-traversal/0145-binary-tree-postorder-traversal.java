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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        //LinkedList<Integer> res = new LinkedList<>(); // option2. implement with only 1stack
        
        // base case
        if(root == null) return res;
        
        // s1 : not visited, s2 : visited
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        s1.push(root);
        
        // traverse tree
        while(!s1.isEmpty()) {
            
            TreeNode node = s1.pop();
            if(node.left != null) s1.push(node.left);
            if(node.right != null) s1.push(node.right);
            
            // put into visited stack
            s2.push(node);
            //res.addFirst(node.val);
        }
        
        while(!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }
}
