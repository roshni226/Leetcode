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
    private TreeNode prev=null;
    private TreeNode x=null;//first violation
    private TreeNode y=null;//second violation
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        if(prev!=null && root.val<prev.val)
        {
            y=root; //Marking root as second violation
            //1. Adjacent- first violation will be prvious node
            //2. Not Adjacent- first violation will already be marked
            // and y value will be updated
            if(x==null)
            {
                x=prev;
            }
            else//got both 1st and 2nd violations
            {
                return;
            }
        }
        prev=root;
        inorder(root.right);
        
    }
    public void swap(TreeNode x, TreeNode y)
    {
        int temp= x.val;
        x.val=y.val;
        y.val=temp;
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(x,y);
    }
}