package cn.henu.software.stu2510250128.ch05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class S5_11 {
    public static void main(String[] args) {
        Random r = new Random();

        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < 10) {
            int num = r.nextInt(101) + 350;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        System.out.println("ArrayList: " + list);

        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 10) {
            set.add(r.nextInt(101) + 350);
        }
        System.out.println("Set: " + set);
    }
}
