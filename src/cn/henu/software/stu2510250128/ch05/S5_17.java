package cn.henu.software.stu2510250128.ch05;

import java.util.ArrayList;

public class S5_17 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + 2) % list.size();
            list.remove(index);
        }
        System.out.println(list.get(0));
    }
}
