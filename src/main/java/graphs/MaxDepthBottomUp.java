package graphs;

public class MaxDepthBottomUp {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2,
                new TreeNode(4,
                        new TreeNode(6),
                        new TreeNode(9)),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));

        int maxDepth = getMaxDepth(t);
        System.out.println(maxDepth);

    }

    static int getMaxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left_depth = getMaxDepth(root.left);
        int right_depth = getMaxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }
}
