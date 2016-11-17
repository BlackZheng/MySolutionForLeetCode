import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> leftStk = new LinkedList<TreeNode>(), rightStk = new LinkedList<TreeNode>();
        if(root != null)
            leftStk.push(root);
        while(!leftStk.isEmpty() || !rightStk.isEmpty()){
            TreeNode node;
            if(!leftStk.isEmpty())
                node = leftStk.pop();
            else
                node = rightStk.pop();
            result.add(node.val);
            if(node.left != null)
                leftStk.push(node.left);
            if(node.right != null)
                rightStk.push(node.right);
        }
        return result;
    }
}
