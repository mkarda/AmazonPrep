package graphs;

public class MaxDepthTopBottom {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2,
                            new TreeNode(4,
                                    new TreeNode(6),
                                    new TreeNode(9)),
                            new TreeNode(2,
                                    new TreeNode(7),
                                    new TreeNode(4)));

        getMaxDepth(t, 1);
        System.out.println(ans);
    }

    static int ans;

    static void getMaxDepth(TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }

        getMaxDepth(root.left, depth + 1);
        getMaxDepth(root.right, depth + 1);
    }
}
