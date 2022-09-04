package day_08.day_0803.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			Car car = null;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = st.nextToken().charAt(0) - '0';
			int W = st.nextToken().charAt(0) - '0';
			
			char[][] arr = new char[H][W];
			for(int i = 0; i < H; i++) {
				String msg = br.readLine();
				for(int j = 0; j < W; j++) {
					arr[i][j] = msg.charAt(j);
					char temp = arr[i][j];
					if(temp == '>' || temp == '<' || temp == '^' || temp == 'v') {
						car = new Car(i, j, temp);
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			char[] action = br.readLine().toCharArray();
			
			for(int i = 0; i < N; i++) {
				switch(action[i]) {
				case 'U':
					break;
				case 'D':
					break;
				
				}
			}
		}
	}
	
	static class Car {
		int r, c;
		char type;
		
		public Car(int r, int c, char type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
		
	}
}