package graphs;

import java.util.ArrayList;
import java.util.List;

public class NthAncestor {

    static TreeNode ans = null;
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1), null),
                new TreeNode(7,
                        new TreeNode(6), null));

        //val 6 - anc 1 -> should give 7

        int node = 6;
        int k = 1;

        List<TreeNode> visited = new ArrayList<>();


        getAncestor(tree1, node, k, visited);
        if (ans != null) {
            System.out.println(ans.val);
        } else {
            System.out.println("nothing");
        }
    }

    static TreeNode getAncestor(TreeNode root, int node, int k, List<TreeNode> visited) {

        if (root == null) return null;
        visited.add(root);

        if (root.val == node) {
            ans = visited.get(visited.size() - 1 - k);
        }

        if (getAncestor(root.left, node, k, visited) == null) {
            visited.remove(visited.size()-1);
            return root;
        }
        if (getAncestor(root.right, node, k, visited) == null) {
            visited.remove(visited.size()-1);
            return root;

        }

        return null;

    }
}
