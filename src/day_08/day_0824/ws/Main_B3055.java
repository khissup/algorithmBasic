package day_08.day_0824.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B3055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		Pos hedgePos = new Pos();
		List<Pos> waterPos = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'S') {
					hedgePos = new Pos(i, j, "hedge", 0);
				} else if(map[i][j] == '*') {
					waterPos.add(new Pos(i, j, "water", 0));
				}
			}
		}
		Escape escape = new Escape(map, hedgePos, waterPos);
		escape.next();
		if(escape.escapeTime == 0) {
			sb.append("KAKTUS");
		} else {
			sb.append(escape.escapeTime);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
class Escape {
	char[][] map; // 맵
	Pos hedgePos; // 고슴도치 위치
	List<Pos> waterPos; // 물 위치
	int[][] stonePos;
	boolean[][] visit;
	int[] dy = {-1, 1, 0, 0};
	int[] dx = {0, 0, 1, -1};
	int escapeTime = 0;
	Queue<Pos> moving;
	
	public Escape(char[][] map, Pos hedgePos, List<Pos> waterPos) {
		this.map = map;
		this.hedgePos = hedgePos;
		this.waterPos = waterPos;
		visit = new boolean[map.length][map[0].length];
		moving = new LinkedList<>();
		for(int i = 0; i < waterPos.size(); i++) {
			Pos temp = waterPos.get(i);
			visit[temp.y][temp.x] = true; 
			moving.offer(temp);
		}
		moving.offer(hedgePos);
		visit[hedgePos.y][hedgePos.x] = true; 
	}
	
	public void next() {
		int nx, ny;
		Pos temp;
		while(!moving.isEmpty()) {
			temp = moving.poll();
			String type = temp.type;
		
			for (int i = 0; i < 4; i++) {
				ny = temp.y + dy[i];
				nx = temp.x + dx[i];
				
				if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length && map[ny][nx] != 'X' && visit[ny][nx] == false) {
					if(map[ny][nx] == 'D') {
						if(type.equals("hedge")) {
							escapeTime = temp.depth + 1;
							return;
						} else {
							break;
						}
					}
					visit[ny][nx]= true;
					moving.offer(new Pos(ny, nx, type, temp.depth + 1));
				}
			}
		}
	}
}
class Pos {
	int y;
	int x;
	int depth;
	String type;
	public Pos (int y, int x, String type, int depth) {
		this.y = y;
		this.x = x;
		this.type = type;
		this.depth = depth;
	}
	public Pos() {};
}
