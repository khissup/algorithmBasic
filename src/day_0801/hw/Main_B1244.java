package day_0801.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1244 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int switchQuantity = Integer.parseInt(in.readLine());
		int[] switchState = new int[switchQuantity];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < switchQuantity; i++) {
			switchState[i] = Integer.parseInt(st.nextToken());
		}

		int studentQuantity = Integer.parseInt(in.readLine());
		for(int i = 0; i < studentQuantity; i++) {
			st = new StringTokenizer(in.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int choice = Integer.parseInt(st.nextToken());
			if(sex == 1) {
				while(choice - 1 < switchQuantity) {
					if(switchState[choice - 1] == 0) {
						switchState[choice - 1] = 1;
					} else {
						switchState[choice - 1] = 0;
					}
					choice *= 2;
				}
			} else {
				int leftIndex = choice - 1;
				int rightIndex = choice + 1;
				if(switchState[choice - 1] == 0) {
					switchState[choice - 1] = 1;
				} else {
					switchState[choice - 1] = 0;
				}
				while(leftIndex - 1 >= 0 && rightIndex - 1 < switchQuantity) {
					// 양옆의 스위치가 같다면
					if((switchState[leftIndex - 1] ^ switchState[rightIndex - 1]) == 0) {
						if(switchState[leftIndex - 1] == 0) {
							switchState[leftIndex - 1] = 1;
							switchState[rightIndex - 1] = 1;
						} else {
							switchState[leftIndex - 1] = 0;
							switchState[rightIndex - 1] = 0;
						}
						leftIndex -= 1;
						rightIndex += 1;
					} else {
						break;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < switchQuantity; i++) {
			sb.append(switchState[i]);
			sb.append(" ");
			// 20 개 출력할때마다 다음줄로 넘어감
			if(i != 0 && i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}