import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> level = new LinkedList<TreeNode>();
        LinkedList<TreeNode> lastLevel = new LinkedList<TreeNode>();
        if(root != null)
            level.offer(root);
        while(!level.isEmpty()){
            lastLevel.addAll(level);
            level.clear();
            List<Integer> levelVal = new ArrayList<Integer>();
            while(!lastLevel.isEmpty()){
                TreeNode node = lastLevel.poll();
                levelVal.add(node.val);
                if(node.left != null)
                    level.offer(node.left);
                if(node.right != null)
                    level.offer(node.right);
            }
            result.add(levelVal);
        }
        return result;
    }
}
