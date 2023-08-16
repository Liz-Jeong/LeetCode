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

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
        
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        this.preorder = preorder;
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);     // value, index
        }
        
        int len = preorder.length;
        TreeNode root = DFS(0, len - 1);
        
        return root;
    }

    private TreeNode DFS(int start, int end) {
        
        // base case
        if(start > end) return null;
        
        // build the tree node
        int currVal = preorder[index++];
        TreeNode cur = new TreeNode(currVal);
        
        int mid = map.get(currVal);
        
        // build the left subtree
        cur.left = DFS(start, mid - 1);

        // build the left subtree
        cur.right = DFS(mid + 1, end);
        
        // return 
        return cur;
    }
    
    // [recursive]
    // if(preorder.length > 0 && inorder.length > 0){
    //     // LEFT
    //     left = buildTree(Arrays.copyOfRange(preorder, 1, inorder.indexOf(preorder[0]))
    //           , Arrays.copyOfRange(inorder, 0, inorder.indexOf(preorder[0])));
    //     // RIGHT
    //     right = buildTree(Arrays.copyOfRange(preorder, inorder.indexOf(preorder[0]), preorder.length)
    //               , Arrays.copyOfRange(inorder, preorder[0] + 1, inorder.length));
    // }
}