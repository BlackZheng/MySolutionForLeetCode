//This a DFS solution
public class SumRoottoLeafNumbers {
	int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        else{
            helper(root.val, root);
            return result;
        }
    }
    public void helper(int cumulation, TreeNode node){
        if(node.left == null && node.right == null)
            result += cumulation;
        else{
            if(node.left != null)
                helper(cumulation * 10 + node.left.val, node.left);
            if(node.right != null)
                helper(cumulation * 10 + node.right.val, node.right);
        }
    }
}
