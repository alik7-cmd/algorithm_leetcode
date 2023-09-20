package agoda;

import java.util.ArrayDeque;
import java.util.Deque;


class TreeNode{

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}
public class TreeAlgoTest {

    public void inorder(TreeNode head){
        if(head == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = head;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            TreeNode node = stack.pop();
            System.out.println(node.data);
            current = current.right;
        }
    }
}
