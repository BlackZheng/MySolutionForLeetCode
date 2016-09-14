import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int start = newInterval.start;
        int end = newInterval.end;
        for(int i = 0; i < intervals.size(); i++){
        	Interval cur = intervals.get(i);
        	if(end < cur.start){
        		LinkedList<Interval> list = new LinkedList<Interval>();//I hava to transform List into LinkedList so that I can insert an Interval in the middle place
        		list.addAll(intervals);
        		list.add(i, newInterval);
        		return list;
        	}
        	if(start < cur.start)
        		cur.start = start;
        	else if(start > cur.end)
        		continue;
        	if(end < cur.end)
        		return intervals;
        	else{
        		for(int j = i + 1; j < intervals.size(); ){
        			Interval in = intervals.get(j);
        			if(end < in.start){
        				cur.end = end;
        				return intervals;
        			}
        			else if(end < in.end){
        				cur.end = in.end;
        				intervals.remove(j);
        				return intervals;
        			}
        			intervals.remove(j);
        		}
        		cur.end = end;
        		return intervals;
        	}
        }
        intervals.add(newInterval);
		return intervals;
	}
}
