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
    public TreeNode delete(TreeNode root, int key)
    {
        //first search the node
        //1. node not found
        if(root==null)
            return null;
        //2.node is in left subtree
        if(root.val>key)
            root.left= delete(root.left,key);
        //3.node is in right subtree
        else if(root.val<key)
            root.right= delete(root.right,key);
        //4.root.val=key
        else
        {
            //case 1: leaf node
            if(root.left==null && root.right==null)
            {
                return null;//return null to parent node to delete
            }
            //case 2: single child
            if(root.left==null)
            {
                return root.right;//return the child node to the parent
            }
            if(root.right==null)
            {
                return root.left;
            }
            //case 3: more than one child: replace curr root with its IS
            TreeNode IS= inorderSuccessor(root.right);
            root.val=IS.val;//change value of root node IS's value
            root.right= delete(root.right,IS.val); //delete IS from root's right
        } 
        return root;        
    }
    
    public TreeNode inorderSuccessor(TreeNode root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        root=delete(root,key);
        return root;
    }
}