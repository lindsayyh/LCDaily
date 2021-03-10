package Leetcode;

public class MeetingRoom1 {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals,(i1,i2)->(i1[0]-i2[0]));
        int end = intervals[0][1];
        for(int i = 1;i<intervals.length;i++){
            if(end>intervals[i][0]){
                return false;
            }
            end = intervals[i][1];
        }
        return true;
    }
}
