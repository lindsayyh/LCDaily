package Leetcode;

public class LC1288 {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals,(i1,i2)->(i1[0]==i2[0]?i2[1]-i1[1]:i1[0]-i2[0]));
            int rightMost = intervals[0][1];
            int result = intervals.length;
            for(int i = 1;i<intervals.length;i++){
                if(rightMost>=intervals[i][1]){
                    result--;
                }else{
                    rightMost = intervals[i][1];
                }
            }
            return result;
        }
    }
}
