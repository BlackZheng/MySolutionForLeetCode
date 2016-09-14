import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
        for(int i = 0; i < intervals.size(); ){
			Interval current = intervals.get(i);
			if(i + 1 < intervals.size()){
				Interval next = intervals.get(i + 1);
				if(next.start > current.end){
					i ++;
					continue;
				}
				else{
					if(next.start < current.start){
						if(next.end < current.start){
							Collections.swap(intervals, i, i + 1);
							i ++;
							continue;
						}
						else
							current.start = next.start;
					}
					if(next.end > current.end)
						current.end = next.end;
					intervals.remove(next);
				}
			}
			else
				break;

		}
        return intervals;
    }
}
