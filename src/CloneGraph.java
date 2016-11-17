import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode newNode = null;
        if(node != null){
            newNode = new UndirectedGraphNode(node.label);
            helper(node, newNode, new HashMap<Integer, UndirectedGraphNode>());
        }
        return newNode;
    }
	/**
	 * 
	 * @param src Source node to copy
	 * @param dst The cloned node
	 * @param visited Map to store the reference of node having created
	 */
    public void helper(UndirectedGraphNode src, UndirectedGraphNode dst, Map<Integer, UndirectedGraphNode> visited){
        visited.put(dst.label, dst);
        for(UndirectedGraphNode node : src.neighbors){
            if(visited.containsKey(node.label))
                dst.neighbors.add(visited.get(node.label));
            else{
                UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
                dst.neighbors.add(newNode);
                helper(node, newNode, visited);
            }
                
        }
    }
}
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};