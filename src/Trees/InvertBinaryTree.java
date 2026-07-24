package trees;
import java.util.LinkedList;
import java.util.Queue;

// Choosing the stack depends on the purpose 
// Stack: LIFO - Depth First Search
//  you push nodes onto the stack and always pop the mos recent one
//  results in you diving down the deepest leaf node before backtracking
//  best used for pre-order, in-ordeer, and post-order traversals, finding paths, or checking tree balanlce

// Queue: Breadth-first-search
//  you add nodes to the end of the queue and alwayas process from the front
//  results in you exploring the tree layer by layer, from top to bottom, left to right 
//  best for level-order traversals, finding the shortest path to a node, or serialization

// The Exception: Morris Traversal
//  best for memory constrained scenarios
//  If you cannot afford extra memory, yuou temporarily rewrite the trees empty right-child pointers to point back to their parent nodes.

public class InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return null;}

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();

        // Constructing the tree based on the array [3, 2, 1]
        // Root: 3, Left: 2, Right: 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        System.out.print("Original Tree (Level-order): ");
        printTree(root);

        // Invert the tree
        TreeNode invertedRoot = ibt.invertTree(root);

        System.out.print("Inverted Tree (Level-order): ");
        printTree(invertedRoot);
    }
}
