package graphs;

import java.util.ArrayList;
import java.util.List;

public class CheckIfSameInoder {

    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1), null),
                new TreeNode(7,
                        new TreeNode(6), null));

        TreeNode tree2 = new TreeNode(3,
                new TreeNode(1),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7)));

        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();

        inorder(tree1, list1);
//        inorder(tree2, list2);

//        boolean isSame = list1.equals(list2);
//        System.out.println(isSame);

        boolean ans = inOrderCheck(tree2, list1);
        System.out.println(ans);



    }

    static void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }

    static boolean inOrderCheck(TreeNode root, List<Integer> list) {
        if (root == null) return true;

        if (!inOrderCheck(root.left, list)) {
            return false;
        }

        if (list.isEmpty() || list.get(0) != root.val) {
            return false;
        }
        list.remove(0);

        return inOrderCheck(root.right, list);
    }
}
