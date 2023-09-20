package tree;
import java.util.*;


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
class Tree{

    TreeNode root;

    public Tree(int data) {
        root = new TreeNode(data);
    }
}

// [1,2,3,4,5,6,7,8]


class TreeImpl{

    public static void main(String [] args){
        Tree tree = new Tree(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(34);
    }


}

public class TreeAlgo {

    /**
     *
     * @param root is an instance of [TreeNode]
     *
     *          1
     *        /  \
     *       2    3
     *      / \
     *     4   5
     *
     *  Output : 1,2,4,5,3
     *  Time Complexity is O(N)
     *
     */
    public void preorderWithoutRecursion(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.println(node.data);
            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }

    }

    /**
     *
     * @param root is an instance of [TreeNode]
     *
     *          1
     *        /  \
     *       2    3
     *      / \
     *     4   5
     *
     *  Output : 4,2,5,1,3
     *  Time Complexity is O(N)
     *
     */
    public void inorderWithoutRecursion(TreeNode root){

        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while ( current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }

    /**
     *
     * @param root is an instance of [TreeNode]
     *
     *          1
     *        /  \
     *       2    3
     *      / \
     *     4   5
     *
     *  Output : 4,5,2,3,1
     *  Time Complexity is O(N^2)
     *  See : https://www.geeksforgeeks.org/postorder-traversal-binary-tree-without-recursion-without-stack/
     *
     */
    public void postOrderWithoutRecursion(TreeNode root){
        HashSet<TreeNode> visited = new HashSet<>();
        TreeNode temp = root;

        while (temp != null && !visited.contains(temp)){
            // Visited left subtree
            if (temp.left != null &&
                    !visited.contains(temp.left))
                temp = temp.left;

                // Visited right subtree
            else if (temp.right != null &&
                    !visited.contains(temp.right))
                temp = temp.right;

                // Print node
            else
            {
                System.out.printf("%d ", temp.data);
                visited.add(temp);
                temp = root;
            }
        }
    }

    /**
     * Complexity O(h)
     * @param root
     * @param key
     * @return
     */
    public TreeNode insertInBST(TreeNode root, int key){
        TreeNode newNode = new TreeNode(key);
        if(root == null) return newNode;

        while (root != null){
            if(root.data > key){
                root = root.left;
            }else {
                root = root.right;
            }
        }

        if(key > root.data){
            root.right = newNode;
        }else {
            root.left = newNode;
        }

        return newNode;

    }

    /**
     * This is algorithm to delete node in BST
     * Complexity : O(h)
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteInBST(TreeNode root, int key){

        if(root ==null) return root;
        if(key > root.data) root.right = deleteInBST(root.right, key);
        else if(key < root.data) root.left = deleteInBST(root.left, key);

        else {

            if(root.left ==null) return root.right;
            else if(root.right == null) return root.left;
            else {
                int min = minValue(root.right);
                root.right = deleteInBST(root.right, root.data);
            }

        }

        return root;

    }

    int minValue(TreeNode root) {
        int min = root.data;

        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    /**
     * This is basically search in a BST
     * Complexity O(h)
     * @param root
     * @param val
     * @return
     */
    public boolean isDataPresentInBST(TreeNode root, int val){

        if(root == null) return false;

        if(root.data == val) return true;

        TreeNode current = root;

        while (current != null){

            if(current.data > val){
                current = current.left;
            }

            else if(current.data < val){
                current = current.left;
            }

            else {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param arr, sorted array on integer
     * @param l, start index of array, 0
     * @param r, last index of array n-1
     * @return root of the Tree
     *
     * Input: Array {1, 2, 3, 4}
     * Output: A Balanced BST
     *       3
     *     /  \
     *    2    4
     *  /
     * 1
     * Time Complexity: O(n)
     */
    public TreeNode arrayToBalancedBST(int [] arr, int l, int r){
        int mid = l +(r-l)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrayToBalancedBST(arr, l , mid-1);
        root.right = arrayToBalancedBST(arr, mid+1 , r);
        return root;

    }

    /**
     * Time Complexity: O(n)
     * @param root
     * @return an integer, indicating the height of BST
     */
    int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int lefth = findHeight(root.left);
        int righth = findHeight(root.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public void reverseTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp  = node.left;
            node.left = node.right;
            node.right = temp;


            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }

        }
    }

}

