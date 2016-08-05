/**
 * Thought of this solution is by MissMary
 * explanation:https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation  */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m, n, imin, imax, i, j, half_len, max_left, min_right;
        m = nums1.length;
        n = nums2.length;
        if(m > n){
        	int[] temp = nums1;
        	nums1 = nums2;
        	nums2 = temp;
        	m = nums1.length;
            n = nums2.length;
        }
        imin = 0;
        imax = m;
        half_len = (m + n + 1)/2; 
        while(imin <= imax ){
        	i = (imin + imax)/2;
        	j = half_len - i;
        	if(i > 0 && j < n && nums1[i - 1] > nums2[j]){
        		imax = i - 1;
        	}
        	else if(j > 0 && i < m && nums2[j - 1] > nums1[i]){
        		imin = i + 1;
        	}
        	else{
		        if(j == 0)
		        	max_left = nums1[i -1];
		        else if(i == 0)
		        	max_left = nums2[j - 1];
		        else
		        	max_left = max(nums1[i -1 ], nums2[j - 1]);
		        if((m + n)%2 == 1){
		        	return (double)max_left;
		        }
		        if(i == m)
		        	min_right = nums2[j];
		        else if(j == n)
		        	min_right =nums1[i];
		        else
		        	min_right = min(nums1[i], nums2[j]);
		        return (max_left + min_right) / 2.0;
        	}
        }
        return 0;
    }
    public int max(int a, int b){
		return a > b ? a : b;
	}
	public int min(int a, int b){
		return a > b ? b : a;
	}
}
