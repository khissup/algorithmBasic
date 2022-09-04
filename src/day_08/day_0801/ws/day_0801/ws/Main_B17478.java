package day_08.day_0801.ws.day_0801.ws;

import java.util.Scanner;

public class Main_B17478 {
	public static String str1 = "\"재귀함수가 뭔가요?\""; 
	public static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어."; 
	public static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."; 
	public static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	public static String staticRepeat = "";
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		print(num);
		System.out.println(sb.toString());
	}	
	
	public static void print(int count) {
		String repeat = staticRepeat;
		if(count < 0) {
			return;
		}
		/*
		System.out.println(repeat + str1);
		System.out.println(repeat + str2);
		System.out.println(repeat + str3);
		System.out.println(repeat + str4);
		staticRepeat += "____";
		*/
		sb.append(repeat);
		sb.append(str1);
		sb.append("\n");
		sb.append(repeat);
		sb.append(str2);
		sb.append("\n");
		sb.append(repeat);
		sb.append(str3);
		sb.append("\n");
		sb.append(repeat);
		sb.append(str4);
		sb.append("\n");
		staticRepeat += "____";
		print(count - 1);
		//System.out.println(repeat + "라고 답변하였지");
		sb.append(repeat);
		sb.append("라고 답변하였지.");
		sb.append("\n");
	}
}
