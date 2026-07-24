package trees;

public class KthSmallestElement {

    private int count = 0;
    private int result = -1;

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

    public void traverse(TreeNode root, int k) {
        if (root == null || k < 0) { return;} 

        traverse(root.left, k);
        count++;

        if (count == k) {
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int k = 2;

        int output = kse.kthSmallest(root, k);
        System.out.print(output);
    
    }
}
