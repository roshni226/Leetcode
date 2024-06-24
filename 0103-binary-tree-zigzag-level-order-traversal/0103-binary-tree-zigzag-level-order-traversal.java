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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> temp= new ArrayList<>();
        q.add(root);
        q.add(null);
        int level= 1;

        while(!q.isEmpty())
        {
            TreeNode curr= q.remove();
            if(curr== null)
            {
                if(level%2==0)
                {
                    Collections.reverse(temp);
                    ans.add(new ArrayList<>(temp));
                }
                else
                    ans.add(new ArrayList<>(temp));
                
                if(q.isEmpty())
                {
                    break;
                }
                q.add(null);
                level++;
                temp.clear();
            }
            else
            {
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return ans;
    }
}