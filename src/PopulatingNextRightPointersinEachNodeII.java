import java.util.LinkedList;


public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if(root != null)
            queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode node = queue.poll();
                if(i < size - 1)//we just ignore the last node of each level
                    node.next = queue.peek();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)//This is the difference from PopulatingNextRightPointersinEachNode I
                    queue.offer(node.right);
            }
        }
    }
}
