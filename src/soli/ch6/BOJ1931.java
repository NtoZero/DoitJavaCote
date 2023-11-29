package soli.ch6;

import _problems.ch6_greedy.P35_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 implements P35_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());;

            meetings[i] = new Meeting(start, end);
        }

        // 실제로 비교해서 정렬시킬 수 있도록 메서드 호출
        Arrays.sort(meetings);

        // 회의 수
        int count = 0;
        // 회의 시간 중 마지막 시간
        int meetingEnd = 0;

        for(Meeting meeting : meetings) {
            // 회의 시작 시간이 현재 시간이랑 안 겹치면 (회의 시작이 늦으면)
            if(meeting.start >= meetingEnd) {
                // 회의 선택
                meetingEnd = meeting.end;
                count++;
            }
        }
        System.out.println(count);
    }

    // 회의시간 비교해서 정렬시키는 Meeting 클래스
    private static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                // 끝나는 시간 같으면 시작 시간 빠른 거 부터 정렬
                return this.start - o.start;
            }
            // 끝나는 시간 다를 때 끝나는 시간이 빠른대로 정렬
            return this.end - o.end;
        }
    }
}
