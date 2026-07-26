# Binary Tree Maximum Path Sum Summary 
# Data Structures & Algorithms: Tree Paths & Max Path Sum Summary

## 1. Tree Path Foundations
* **Definition**: A sequence of connected nodes in a tree where no node or edge is repeated.
* **Adjacency Requirement**: Two nodes are only adjacent if they have a direct parent-child relationship (sharing a single edge). 
* **Traversals and Adjacency**: 
  * **In-Order** reads the tree from left to right chronologically but jumps across branches, breaking physical adjacency.
  * **Post-Order (Bottom-Up)** guarantees adjacency because children process their data first and pass it directly to their immediate parent.

---

## 2. Maximum Path Sum Logic (LeetCode 124)
To find the maximum path sum in a tree that contains both positive and negative numbers, you must handle two critical mechanics at every single node:

* **The "Drop" Decision**: If a child subtree yields a negative sum, it hurts the total score. The parent filters it out using `Math.max(0, gain)`, effectively dropping that branch from the path.
* **The Split Rule (No Forking)**: A valid tree path cannot split into a "Y" shape. 
  * **Locally**: A node can combine both of its children to form an arch to check against the global maximum (`left + right + root.val`).
  * **Globally**: When returning data to its parent node above, it can only pick **one** best side to keep the path straight (`root.val + Math.max(left, right)`).

---

## 3. Verified Java Solution

Below is the correct, optimized implementation developed through architectural refinement:

```java
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
    // Tracks the absolute highest path sum found across the entire tree
    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) { 
            return 0;
        }
        
        postorder(root);
        return globalMax;
    }

    /**
     * Helper function that uses post-order traversal to calculate single-line gains.
     */
    private int postorder(TreeNode root) {
        // Base Case: An empty node contributes nothing to the path sum
        if (root == null) { 
            return 0;
        }

        // 1. Explore children first (Post-Order) and drop negative contributions
        int leftGain = Math.max(0, postorder(root.left));
        int rightGain = Math.max(0, postorder(root.right));

        // 2. Calculate the local "arch" peak at the current node
        int localMax = leftGain + rightGain + root.val;

        // 3. Update the global record if this local arch is the highest seen so far
        globalMax = Math.max(globalMax, localMax);

        // 4. Return the maximum straight-line path up to the parent
        return root.val + Math.max(leftGain, rightGain);
    }
}
```

### Key Technical Takeaways From Implementation:
1. **Scoping**: Child gains must be kept inside **local variables** within the recursive method so they do not overwrite each other during the tree dive.
2. **Initialization**: The global tracker must start at `Integer.MIN_VALUE` rather than `0` to safely handle trees containing only negative numbers.
3. **Delegation**: Avoid safety checks like `if (root.left == null)` in the main function. Let the core recursive base case (`root == null`) elegantly handle empty branches uniformly.
