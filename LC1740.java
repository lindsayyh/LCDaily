package Leetcode;

public class LC1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode node = LCA(root,p,q);
        return findDist(node,p,0)+findDist(node,q,0);
    }

    private int findDist(TreeNode root, int val, int depth){
        if(root == null){
            return -1;
        }
        if(root.val == val){
            return depth;
        }
        int left = findDist(root.left,val,depth+1);
        int right = findDist(root.right,val,depth+1);
        return left == -1?right:left;

    }

    public TreeNode LCA(TreeNode root, int p, int q) {
        if(root == null || root.val == p || root.val == q){
            return root;
        }
        TreeNode left = LCA(root.left,p,q);
        TreeNode right = LCA(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        return left == null?right:left;
    }
}
