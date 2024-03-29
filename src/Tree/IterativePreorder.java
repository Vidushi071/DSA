package Tree;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public class IterativePreorder {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> li = new ArrayList<>();
            if (root == null) return li;
            Stack<Integer> st = new Stack<>();
            st.push(root);
            while (!st.isEmpty()) {
                root = st.pop();
                li.add(root.val);
                if (root.right != null)
                    st.push(root.right);
                if (root.left != null)
                    st.push(root.left);
            }
            return li;
        }
    }
