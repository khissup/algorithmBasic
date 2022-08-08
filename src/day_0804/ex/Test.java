package day_0804.ex;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
		Queue<Integer> pw = new ArrayDeque<>();
		pw.offer(10);
		pw.offer(20);
		pw.offer(30);
		System.out.println(pw.poll());
		System.out.println(pw.size());
		
	}
}
