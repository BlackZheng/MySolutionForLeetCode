
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length < 1)
			return null;
		TreeNode root = new TreeNode(preorder[0]);
		helper(root, preorder, inorder, 0, 0, inorder.length - 1);
        return root;
    }
	
	/**
	 * 
	 * @param root 
	 * @param pre 
	 * 	Preorder sequence
	 * @param in 
	 * 	Inorder sequence
	 * @param rootIdxInPre 
	 * 	The index of root in preorder sequence
	 * @param startIn 
	 * 	The starting index of the target range of inorder sequence
	 * @param endIn 
	 * 	The ending index of the target range of inorder sequence
	 */
	public void helper(TreeNode root, int[] pre, int[] in, int rootIdxInPre, int startIn, int endIn){
		int leftCount = 0, rightCount = 0;
		int rootIdxIn = startIn;
		while(in[rootIdxIn] != root.val)// locate the index of root in inorder seq.
			rootIdxIn++;
		leftCount = rootIdxIn - startIn; // the quantity of nodes of the left subtree 
		rightCount = endIn - rootIdxIn; // the quantity of nodes of the right subtree 
		if(leftCount > 0){
			TreeNode left = new TreeNode(pre[rootIdxInPre + 1]);
			root.left =left;
			helper(left, pre, in, rootIdxInPre + 1, startIn, rootIdxIn - 1);
		}
		if(rightCount > 0){
			TreeNode right = new TreeNode(pre[rootIdxInPre + leftCount + 1]);
			root.right = right;
			helper(right, pre, in, rootIdxInPre + leftCount + 1, rootIdxIn + 1, endIn);
		}
	}
}
