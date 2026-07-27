package trees;
import utils.MyClass;

public class BtMaxPathSum {

    public int localMax = 0;
    public int globalMax = Integer.MIN_VALUE;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public int postorder (TreeNode root) {
        if (root == null) { return 0;}

        int leftGain = postorder(root.left);
        leftGain = Math.max(0, leftGain);

        int rightGain = postorder(root.right);
        rightGain = Math.max(0, rightGain);

        localMax = leftGain + rightGain + root.val;
        globalMax = Math.max(globalMax, localMax);

        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) { return -1;}
        postorder(root);
        return globalMax;
    }
    public static void main(String[] args) {
        BtMaxPathSum btmps = new BtMaxPathSum();

        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20, new TreeNode(15, new TreeNode(-5), null), new TreeNode(5));

        int output = btmps.maxPathSum(root);

        MyClass.log("Max Path Sum: " + output);

    }
}
