package day_0829.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution4 {

    static int N, max,totalCnt, min,map[][];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<int[]> list;  //고려해야하는 코어 리스트 정보
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            list = new ArrayList<int[]>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if((i==0 || j==0 || i==N-1 || j==N-1) && map[i][j] ==1) continue;  // 가장자리 무시 , 가장자리에 위치한 코어는 이미 연결한 것으로 간주한다.
                    if(map[i][j]==1) { // 가장자리가 아닌 코어는 리스트에 추가
                        list.add(new int[] {i,j});
                        totalCnt++;  //코어 개수
                    }
                }
            }
            go(0,0);  // 코어 선택 O => 전선연결 O , 코어선택 X => 전선연결 X
            System.out.println("#"+t+" "+min);
        }
    }
    //부분집합에 포합된 코어index
    private static void go(int index,int cCnt) { //cCnt : 현재까지 연결된 코어수

        // 가지치기
        if(totalCnt-index+cCnt<max) return; // totalCnt-index: 남은 코어수
        if(index == totalCnt) {
            int res = getLength();
            if(max<cCnt) {
                max = cCnt;
                min = res;
            }else if(max==cCnt) {
                if(min>res) min = res;
            }
            return;
        }
        int[] cur = list.get(index);
        int r = cur[0];
        int c = cur[1];
        for (int d = 0; d < 4; d++) { // 4방향 모두 따져 보기
            if(isAvailable(r, c, d)) { // 해당방향으로 가장자리까지 닿을 수 있다면 전원연결 가능
                setStatus(r, c, d, 2); // 전선연결 , 2로마킹
                go(index+1,cCnt+1); //전선연결후 => 다음 코어로 넘어감
                setStatus(r,c,d,0);    //연결했던 전선 취소, 0으로 마킹  , 상하좌우에서 연결 , 비연결 작업
            }
        }
        go(index+1,cCnt); // 해당 코어를 전원에 연결하지 않고 다음 코어로 넘어감
    }
    private static boolean isAvailable(int r,int c ,int d) { //이위치(코어의 위치)에서 이 d방향으로 끝까지 갈수 있는지 check
        int nr=r,nc=c;
        while(true) {
            nr += dr[d];
            nc += dc[d];
            if(nr<0 || nr>=N || nc<0 || nc>=N) break; //=> 끝까지 간 상황 : 연결 가능한상황
            if(map[nr][nc]>=1) return false; // 코어:1 , 전선:2로 마킹된 상황 ,  다른 코어나 전선을 만나면 연결 불가
        }
        return true;
    }
    private static void setStatus(int r,int c,int d, int s) {
        int nr=r,nc=c;
        while(true) {
            nr += dr[d];
            nc += dc[d];
            if(nr<0 || nr>=N || nc<0 || nc>=N) break;
            map[nr][nc] = s;
        }
    }
    private static int getLength() {
        int lCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==2) ++lCnt;
            }
        }
        return lCnt;
    }
}