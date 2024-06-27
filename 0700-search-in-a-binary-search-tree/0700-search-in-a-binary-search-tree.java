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
    static TreeNode subroot;
    public boolean search(TreeNode root, int val)
    {
        if(root==null)
        {
            return false;
        }
        if(root.val==val)
        {
            subroot=root;
            return true;
        }
        boolean ans1=false,ans2=false;
        if(root.val>val)
        {
            ans1=search(root.left,val);
        }
        else
        {
            ans2=search(root.right,val);
        }
        return (ans1||ans2);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        subroot=null;
        search(root,val);
        return subroot;
    }
}