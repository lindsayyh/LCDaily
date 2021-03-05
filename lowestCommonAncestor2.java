package Leetcode;

public class lowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null || q == null){
            return null;
        }
        TreeNode node = helper(root,p,q);
        if(node == null){
            return node;
        }
        if(node!=p && node!=q){
            return node;
        }

        if(node == p && helper(p,q,q)!=null){
            return p;
        }
        if(node == q && helper(q,p,p)!=null){
            return q;
        }
        return null;

    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q ){
            return root;
        }
        TreeNode left = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        return left == null?right:left;
    }
}
