package day_0810.ws;

import java.io.*;
import java.util.StringTokenizer;

public class Main_B16935 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input16926.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = div4turn90(arr);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void turnReverse(int[][] arr, int[][] result, int ni, int nj) {
        if(ni > arr.length && nj > arr[ni].length) {
            return;
        }

    }
    // 1번 연산
    // 상하반전은 1차원배열이 여러개 합쳐진게 2차원배열이므로
    // 일일히 값 다 안바꾸고 주소값 매핑만 서로 바꿔줘도 가능함.
    public static int[][] turnUpDown(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = arr.length - 1; i >= arr.length / 2; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr.length - 1 - i][j] = arr[i][j];
            }
        }
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr.length - 1 - i][j] = arr[i][j];
            }
        }
        return result;
    }
    // 2번 연산
    public static int[][] turnLeftRight(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= arr[i].length / 2; j--) {
                result[i][arr[i].length - 1 - j] = arr[i][j];
            }
            for (int j = arr[i].length / 2 - 1; j >= 0; j--) {
                result[i][arr[i].length - 1 - j] = arr[i][j];
            }
        }
        return result;
    }
    // 3번 연산
    public static int[][] turn90(int[][] arr) {
        // 안쪽 for문이 처음에 읽어나가야 하는 방향
        // 바깥(겉) for문이 안쪽거 다 읽은후 그다음줄 읽을때 방향
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                result[i][arr[i].length - 1 - j] = arr[j][i];
            }
        }
        return result;
    }
    // 4번 연산
    public static int[][] turn270(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr.length - 1 - i][j] = arr[j][i];
            }
        }
        return result;
    }
    // 5번 연산
    public static int[][] div4turn90(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
        int[][] div1 = new int[arr.length / 2][arr[0].length / 2];
        int[][] div2 = new int[arr.length / 2][arr[0].length / 2];
        int[][] div3 = new int[arr.length / 2][arr[0].length / 2];
        int[][] div4 = new int[arr.length / 2][arr[0].length / 2];

        // 왼쪽위
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                div1[i][j] = arr[i][j];
            }
        }
        // 오른쪽위
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = arr.length / 2; j < arr.length - 1; j++) {
                div2[i][j - arr.length / 2] = arr[i][j];
            }
        }
        // 왼쪽아래
        for (int i = arr.length / 2; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                div3[i - arr.length / 2][j] = arr[i][j];
            }
        }
        // 오른쪽아래
        for (int i = arr.length / 2; i < arr.length - 1; i++) {
            for (int j = arr.length / 2; j < arr.length - 1; j++) {
                div4[i - arr.length / 2][j - arr.length / 2] = arr[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i < arr.length / 2 && j < arr.length / 2) {
                    result[i][j] = div3[i][j];
                } else if(i < arr.length / 2 && j >= arr.length / 2) {
                    result[i][j] = div1[i][j - arr.length / 2];
                } else if(i >= arr.length / 2 && j < arr.length / 2) {
                    result[i][j] = div4[i - arr.length / 2][j];
                } else if(i >= arr.length / 2 && j >= arr.length / 2) {
                    result[i][j] = div2[i - arr.length / 2][j - arr.length / 2];
                }
            }
        }
        return result;
    }
}
