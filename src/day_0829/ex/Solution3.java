package day_0829.ex;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        List<Home> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                list.add(new Home(i, j, 10));
            }
        }
        System.out.println(list.get(2).distance);
        System.out.println(list.contains(new Home(0, 0, 10)));
    }
    static class Home {
        int x;
        int y;
        int distance;
        public Home(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
