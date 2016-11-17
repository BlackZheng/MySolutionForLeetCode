import java.util.LinkedList;
import java.util.List;


public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        List<Integer> result = new LinkedList<Integer>();
        if(root != null)
            stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.peek();
            if(node.left == null && node.right == null)
                result.add(stk.poll().val);
            else{
                if(node.right != null){
                    stk.push(node.right);
                    node.right = null;//To prevent from repetitive operation for children of the node.
                }
                if(node.left != null){
                    stk.push(node.left);
                    node.left = null;//To prevent from repetitive operation for children of the node.
                }
            }
        }
        return result;
    }
}
