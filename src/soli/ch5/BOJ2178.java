package soli.ch5;

import _problems.ch5_searching.ch5_2_bfs.P27_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 implements P27_2178 {
    static int N, M; // 미로의 크기를 저장할 변수
    static int[][] maze; // 미로 정보를 저장할 2D 배열
    static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우 방향으로 이동할 때의 x 좌표 변화
    static int[] dy = { 0, 0, -1, 1 }; // 상, 하, 좌, 우 방향으로 이동할 때의 y 좌표 변화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 미로의 행 수
        M = sc.nextInt(); // 미로의 열 수
        sc.nextLine(); // 개행 문자 처리

        maze = new int[N][M]; // 미로 정보를 저장할 2D 배열

        for (int i = 0; i < N; i++) {
            String row = sc.nextLine(); // 한 행의 미로 정보를 입력 받음
            for (int j = 0; j < M; j++) {
                maze[i][j] = row.charAt(j) - '0'; // 미로 정보를 숫자로 변환하여 저장
            }
        }

        int result = bfs(0, 0); // (1, 1)에서 출발하여 (N, M)까지의 최소 칸 수를 계산
        System.out.println(result); // 최소 칸 수 출력
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐 선언
        queue.offer(new int[] { startX, startY }); // 시작 지점을 큐에 추가

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 위치 정보를 꺼냄
            int x = current[0]; // 현재 위치의 x 좌표
            int y = current[1]; // 현재 위치의 y 좌표

            for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우 네 방향을 검사
                int nx = x + dx[i]; // 새로운 x 좌표
                int ny = y + dy[i]; // 새로운 y 좌표

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1) {
                    // 새로운 위치가 미로 내부이며 이동 가능한 경우
                    maze[nx][ny] = maze[x][y] + 1; // 이동 횟수를 증가시킴
                    queue.offer(new int[] { nx, ny }); // 새로운 위치를 큐에 추가
                }
            }
        }

        return maze[N - 1][M - 1]; // (N, M) 위치의 값을 반환하여 최소 칸 수를 반환
    }
}

//import java.io.*;
//        import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken()); // 미로의 행 수
//        int M = Integer.parseInt(st.nextToken()); // 미로의 열 수
//
//        boolean[][] map = new boolean[N][M]; // 미로 정보를 저장할 2D 배열
//
//        for (int i = 0; i < N; i++) {
//            String string = br.readLine();
//            for (int j = 0; j < M; j++) {
//                map[i][j] = string.charAt(j) == '1'; // 문자 '1'을 true로, '0'을 false로 변환하여 미로 정보 저장
//            }
//        }
//
//        int[][] q = new int[N * M][2]; // BFS를 위한 큐
//        q[0][0] = 0;
//        q[0][1] = 0; // 시작 지점 (0, 0)을 큐에 추가
//
//        int[] mx = {0, 0, 1, -1}; // x 좌표 이동 방향 (상, 하, 우, 좌)
//        int[] my = {1, -1, 0, 0}; // y 좌표 이동 방향 (상, 하, 우, 좌)
//
//        int level = 2; // 시작 지점 (0, 0)부터 시작하여 2부터 시작한 이동 횟수
//        int top = 1, bottom = 0; // 큐의 윗 부분과 아랫부분 인덱스를 나타내는 변수
//
//        while (true) {
//            int count = 0; // 현재 레벨에서 방문한 칸 수를 나타내는 변수
//
//            for (int i = bottom; i < top; i++) {
//                int x = q[i][0];
//                int y = q[i][1];
//
//                for (int j = 0; j < 4; j++) {
//                    if (x + mx[j] >= 0 && x + mx[j] < N && y + my[j] >= 0 && y + my[j] < M && map[x + mx[j]][y + my[j]]) {
//                        if (x + mx[j] == N - 1 && y + my[j] == M - 1) {
//                            System.out.println(level); // 도착 지점에 도달하면 이동 횟수를 출력하고 종료
//                            return;
//                        }
//                        map[x + mx[j]][y + my[j]] = false; // 해당 칸을 방문했음을 표시
//                        q[top + count][0] = x + mx[j]; // 다음 위치를 큐에 추가
//                        q[top + count][1] = y + my[j];
//                        count++;
//                    }
//                }
//            }
//
//            bottom = top; // 큐의 아랫부분 인덱스를 업데이트
//            top += count; // 큐의 윗부분 인덱스를 업데이트
//            level++; // 이동 횟수를 증가
//        }
//    }
//}
