
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if(nums.length > 0){
            int idxRoot = nums.length / 2;
            root = new TreeNode(nums[idxRoot]);
            helper(root, idxRoot, 0, nums.length - 1, nums);
        }
        return root;
    }
    public void helper(TreeNode parent, int idxParent, int start, int end, int[] nums){
        if(start < idxParent){
            int leftIdx = (start + idxParent) / 2;
            TreeNode left = new TreeNode(nums[leftIdx]);
            parent.left = left;
            helper(left, leftIdx, start, idxParent - 1, nums);
        }
        if(idxParent < end){
            int rightIdx = (idxParent + end + 1) / 2;
            TreeNode right = new TreeNode(nums[rightIdx]);
            parent.right = right;
            helper(right, rightIdx, idxParent + 1, end, nums);
        }
    }
}
