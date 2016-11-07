import java.util.ArrayList;
import java.util.List;


public class PathSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<Integer>());
        return result;
    }
    public void helper(TreeNode root, int sum, List<Integer> path){
        if(root == null)
            return;
        else
            path.add(root.val);
        if(sum - root.val == 0 && root.left == null && root.right == null){//get the leaf of right path
            result.add(path);
        }else{
            helper(root.left, sum - root.val, new ArrayList<Integer>(path));
            helper(root.right, sum - root.val, new ArrayList<Integer>(path));
        }
    }
}
