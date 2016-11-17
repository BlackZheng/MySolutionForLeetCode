
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        
        if(root.left != null){
        	//insert the left subtree between the parent and right child
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            if(temp != null){
                TreeNode p = root.right;
                while(p.right != null)
                    p = p.right;
                p.right = temp;
            }
        }
    }
}
