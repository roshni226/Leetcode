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
        if(root==null)
            return null;
        
        if(root.val==p.val || root.val==q.val)
            return root;
        
        TreeNode leftSubroot= lowestCommonAncestor(root.left,p,q);
        TreeNode rightSubroot= lowestCommonAncestor(root.right,p,q);
        
        if(rightSubroot==null)
            return leftSubroot;
        else if(leftSubroot==null)
            return rightSubroot;
        else
            return root;
              
    }
}