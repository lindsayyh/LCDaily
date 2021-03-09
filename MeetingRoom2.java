package Leetcode;

public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(i1,i2)->(i1[0]-i2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i = 1;i<intervals.length;i++){
            int[] cur = intervals[i];
            if(!pq.isEmpty() && pq.peek()<=cur[0]){
                pq.poll();
            }
            pq.offer(cur[1]);

        }
        return pq.size();
    }
}
