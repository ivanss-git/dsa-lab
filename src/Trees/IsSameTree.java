package trees;

public class IsSameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) { return p == q;} 
        if (p.val != q.val) { return false;}
        return (p.val == q.val) && sameTree(p.left, q.left) && sameTree(p.right, q.right);
         
    }
    public static void main(String[] args) {
       TreeNode treeOneRoot = new TreeNode(1);
        treeOneRoot.left = new TreeNode(2);
        treeOneRoot.right = new TreeNode(3);

        TreeNode treeTwoRoot = new TreeNode(1);
        treeTwoRoot.left = new TreeNode(2);
        treeTwoRoot.right = new TreeNode(3);
               
        IsSameTree ist = new IsSameTree();
        
        boolean output = ist.sameTree(treeOneRoot, treeTwoRoot);
        System.out.print(output);

    }
}
