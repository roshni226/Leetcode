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
    public void findInSubtree(TreeNode root, int k, List<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        if(k==0)
        {
            ans.add(root.val);
            return;
        }
        
        findInSubtree(root.left,k-1,ans);
        findInSubtree(root.right,k-1,ans);
        
    }
    public int printAllAtK(TreeNode root, TreeNode target, int k,List<Integer> ans)
    {
        if(root==null)
        {
            return -1;//valid target not found
        }
        if(root==target)
        {
            findInSubtree(root,k,ans);
            return 0;//valid target found
        }
        //Distance Left 
        int dl=printAllAtK(root.left,target,k,ans);
        if(dl!=-1)
        {
            if(dl+1==k)
            {
                ans.add(root.val);
                //curr node at kth dist from target node
            }
            else
            {
                findInSubtree(root.right,k-dl-2,ans);//dist to go= k-d
                //target found in left subtree so seach in right
                //extra -2 => travelling from left child till root and travelling from root to right child
                
            }
            return dl+1; //send to parent
        }
        
        //Distance Right
        int dr=printAllAtK(root.right,target,k,ans);
        if(dr!=-1)
        {
            if(dr+1==k)
            {
                ans.add(root.val);
            }
            else
            {
                findInSubtree(root.left,k-dr-2,ans);
            }
            return dr+1;
        }
        
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans= new ArrayList<>();
        printAllAtK(root,target,k,ans);
        return ans;
    }
}