//The main though is familiar with ConstructBinaryTreefromPreorderandInorderTraversal 
//The difference is that the last node in postorder seq is the root of tree in this question.
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length < 1)
			return null;
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		helper(root, inorder, postorder, 0, 0, inorder.length - 1);
        return root;
    }
	
	/**
	 * 
	 * @param root 
	 * @param in 
	 * 	Inorder sequence
	 * @param post 
	 * 	Postorder sequence
	 * @param rootIdxInPost 
	 * 	The index of root in postorder sequence
	 * @param startIn 
	 * 	The starting index of the target range of inorder sequence
	 * @param endIn 
	 * 	The ending index of the target range of inorder sequence
	 */
	public void helper(TreeNode root, int[] in, int[] post, int rootIdxInPost, int startIn, int endIn){
		int leftCount = 0, rightCount = 0;
		int rootIdxIn = startIn;
		while(in[rootIdxIn] != root.val)// locate the index of root in postorder seq.
			rootIdxIn++;
		leftCount = rootIdxIn - startIn; // the quantity of nodes of the left subtree 
		rightCount = endIn - rootIdxIn; // the quantity of nodes of the right subtree 
		if(leftCount > 0){
			int leftNodeIdxInPost = rootIdxInPost - rightCount - 1;
			TreeNode left = new TreeNode(post[leftNodeIdxInPost]);
			root.left =left;
			helper(left, post, in, leftNodeIdxInPost, startIn, rootIdxIn - 1);
		}
		if(rightCount > 0){
			int rightNodeIdxInPost = rootIdxInPost - 1;
			TreeNode right = new TreeNode(post[rightNodeIdxInPost]);
			root.right = right;
			helper(right, post, in, rightNodeIdxInPost, rootIdxIn + 1, endIn);
		}
	}
}
