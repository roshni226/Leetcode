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
    public boolean getPath(TreeNode root, List<TreeNode> path, TreeNode n)
    {
        if(root==null)//node not found in current path
            return false;
        path.add(root);
        if(root.val==n.val)//node found return path
            return true;
        
        //if root.val != n.val then search in roots left and right subtree
        boolean ans1= getPath(root.left,path,n);
        boolean ans2= getPath(root.right,path,n);
        
        if(ans1 || ans2)//node found in left or right subtree
            return true;
        //otherwise remove root from path list as n does'nt exist in a path through root
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1= new ArrayList<>();
        List<TreeNode> path2= new ArrayList<>();
        
        getPath(root,path1,p);
        getPath(root,path2,q);
        int i;
        for(i=0;i<path1.size() && i<path2.size();i++)
        {
            if(path1.get(i).val!=path2.get(i).val)
                break;
        }
        
        return path1.get(i-1);
        
        
    }
}