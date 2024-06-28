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
    public void printPath(TreeNode root, List<Integer> path, List<String> ans)
    {
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            path.add(root.val);
            String a="";
            for(int i=0;i<path.size()-1;i++)
            {
                a+=path.get(i)+"->";
            }
            a+=path.get(path.size()-1);
            ans.add(a);
            path.remove(path.size()-1);
            return;
        }
        
        path.add(root.val);
        printPath(root.left,path,ans);
        printPath(root.right,path,ans);
        path.remove(path.size()-1);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans= new ArrayList<>();
        if(root==null) return ans;
        List<Integer> path= new ArrayList<>();
        printPath(root,path,ans);
        return ans;
    }
}