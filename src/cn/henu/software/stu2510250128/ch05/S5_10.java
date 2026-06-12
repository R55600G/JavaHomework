package cn.henu.software.stu2510250128.ch05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class S5_10 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5); list.add(10); list.add(15); list.add(20); list.add(25);
        list.add(10); list.add(30); list.add(35); list.add(5); list.add(40);

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        boolean found = false;

        ArrayList<Integer> temp = new ArrayList<>();
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer val = it.next();
            if (val == target) {
                found = true;
            }
            if (!temp.contains(val)) {
                temp.add(val);
            } else {
                it.remove();
            }
        }

        System.out.println("是否查找到元素：" + found);
        System.out.println("去重后的集合：" + list);
    }
}