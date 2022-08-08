package day_0804.ws;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_괄호짝짖기 {

	static int N, Res;
	static Map<Character, Character> map = new HashMap<Character, Character>();
	static Stack<Character> stack 	= new Stack<Character>(); //선언 위치에 따라 초기화및 클리어 처리 필요

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1218.txt"));
		Scanner sc = new Scanner(System.in);
        
		//lookup 테이블 구축 
		map.put('}', '{');
		map.put(')', '(');
		map.put('>', '<');
		map.put(']', '[');

		for (int t = 1; t <= 10; t++) {
			Res = 1;
			N = sc.nextInt();
//			stack = new Stack<Character>(); 
			String msg = sc.next().trim();
			if(msg.length() % 2 == 1) { //마치 가지치기 같은 느낌 
				Res = 0;
			}else {
				for(int i=0;i<msg.length();i++) {
					char ch = msg.charAt(i);
					if(ch=='{'||ch=='('||ch=='<'||ch=='[') {
						stack.push(ch);
					}else {
						if(stack.isEmpty() || !stack.pop().equals(map.get(ch))) {
							Res = 0;
							break;
						}
					}
				}
				if(!stack.isEmpty()) Res=0;
			}
			System.out.printf("#%d %s%n", t, Res);
			stack.clear(); //주의한다.
		}
	}
}

