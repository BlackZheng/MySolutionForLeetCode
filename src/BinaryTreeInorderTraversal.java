import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        if(root != null)
            stk.push(root);
        TreeNode curRoot;
        List<Integer> result = new ArrayList<Integer>();
        while(!stk.isEmpty()){
            curRoot = stk.peek();
            if(curRoot.left != null){//push the left child
                stk.push(curRoot.left);
                curRoot.left = null;
            }else{//there is no left child in curRoot, so we can store the value of curRoot 
                result.add(stk.pop().val);
                if(curRoot.right != null)// then take care of its right childtree
                    stk.push(curRoot.right);
            }
        }
        return result;
    }
}
