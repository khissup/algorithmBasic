package day_0924;

import java.util.*;

class Q1 {
    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        String[] commands2 = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] answer;
        String[][] map = new String[51][51];
        List<String> list = new ArrayList<>();
        command(map, commands2, list);
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
    }

    private static void command(String[][] map, String[] command, List<String> list) {
        for(int i = 0; i < command.length; i++) {
            String[] temp = command[i].split(" ");
            switch(temp[0]) {
                case "UPDATE":
                    update(map, temp);
                    break;
                case "MERGE":
                    merge(map, temp);
                    break;
                case "UNMERGE":
                    unmerge(map, temp);
                    break;
                case "PRINT":
                    print(map, temp, list);
                    break;
            }
        }
    }
    private static void update(String[][] map, String[] strTemp) {
        if(strTemp.length == 4) {
            int r = Integer.parseInt(strTemp[1]);
            int c = Integer.parseInt(strTemp[2]);
            if(map[r][c] == null) {
                map[r][c] = strTemp[3];
                return;
            }
            String prevWord = map[r][c];
            map[r][c] = strTemp[3];
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            boolean visited[][] = new boolean[51][51];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{r, c});
            visited[r][c] = true;
            while(!queue.isEmpty()) {
                int[] temp = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int ny = temp[0] + dy[i];
                    int nx = temp[1] + dx[i];
                    if(ny > 0 && ny < 51 && nx > 0 && nx < 51 && visited[ny][nx] == false) {
                        if(map[ny][nx] == null) {
                            continue;
                        }
                        if(prevWord.equals(map[ny][nx])) {
                            visited[ny][nx] = true;
                            map[ny][nx] = strTemp[3];
                            queue.add(new int[]{ny, nx});
                        }

                    }
                }
            }
            return;
        }
        if(strTemp.length == 3) {
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[i].length; j++) {
                    if(map[i][j] == null) {
                        continue;
                    }
                    if(map[i][j].equals(strTemp[1])) {
                        map[i][j] = strTemp[2];
                    }
                }
            }
            return;
        }
    }
    private static void merge(String[][] map, String[] temp) {
        int r1 = Integer.parseInt(temp[1]);
        int c1 = Integer.parseInt(temp[2]);
        int r2 = Integer.parseInt(temp[3]);
        int c2 = Integer.parseInt(temp[4]);//
        map[r2][c2] = map[r1][c1];
    }
    private static void print(String[][] map, String[] temp, List<String> list) {
        int r = Integer.parseInt(temp[1]);
        int c = Integer.parseInt(temp[2]);
        if(map[r][c] == null) {
            list.add("EMPTY");
            return;
        }
        list.add(map[r][c]);
    }
    private static void unmerge(String[][] map, String[] strtemp) {
        int r = Integer.parseInt(strtemp[1]);
        int c = Integer.parseInt(strtemp[2]);
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean visited[][] = new boolean[51][51];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if(ny > 0 && ny < 51 && nx > 0 && nx < 51 && visited[ny][nx] == false) {
                    visited[ny][nx] = true;
                    map[ny][nx] = null;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }
}