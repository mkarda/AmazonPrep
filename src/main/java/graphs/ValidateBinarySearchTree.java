package graphs;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {

        TreeNode t = new TreeNode(5, new TreeNode(1), new TreeNode(4));


        boolean answer = isValid(t);
        System.out.println(answer);

    }

    private static boolean isValid(TreeNode root) {
        return validate(root, null, null);
    }

    static boolean validate(TreeNode root, Integer low, Integer high) {

        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
}
