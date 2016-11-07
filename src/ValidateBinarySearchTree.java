import java.util.LinkedList;


public class ValidateBinarySearchTree {
	
	LinkedList<Integer> list = new LinkedList<Integer>();
	/**
	 * The main thought is inorder traversing nodes. 
	 * If the tree is BST, then the sequence of nodes must be be in the ascending order.
	 * @param root
	 * @return
	 */
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    public boolean helper(TreeNode root){
        if(root == null)
            return true;
        boolean result, flag;
        result = helper(root.left);
        
        if(list.size() != 0){
            flag = root.val > list.getLast();
        }
        else
            flag = true;
        result = result && flag;
        list.add(root.val);
        
        result = result && helper(root.right);
        return result;
    }
}
