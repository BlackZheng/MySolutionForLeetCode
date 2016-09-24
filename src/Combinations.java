import java.util.ArrayList;
import java.util.List;

/**
 * It is a slow method! I will fix it in some day
 * @author BlackZheng
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		recurse(new ArrayList<Integer>(), 1, result, k, n);
        return result;
    }
	public void recurse(List<Integer> list, int level, List<List<Integer>> result, int k, int n){
		if(list.size() == k){
			result.add(list);
			return;
		}
		if(level > n)
			return;
		List<Integer> list1 = new ArrayList<Integer>(list);
		List<Integer> list2 = new ArrayList<Integer>(list);
		list1.add(level);
		level++;
		recurse(list1, level, result, k, n);
		recurse(list2, level, result, k, n);
	}
}
