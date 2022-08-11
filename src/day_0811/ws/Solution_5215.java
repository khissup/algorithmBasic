package day_0811.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 햄버거 다이어트
public class Solution_5215 {
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Integer T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            isSelected = new boolean[N];
            int[] score = new int[N];
            int[] calorie = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                score[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void subset(int now, int sum) {

    }
}
