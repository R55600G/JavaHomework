package cn.henu.software.stu2510250128.ch05;

import java.util.ArrayList;

public class S5_9 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("hello");
        list.add(123);
        list.add(6.9);
        list.add("hello");
        list.add("");
        list.add("Hello");
        StringBuffer s = new StringBuffer("hello");
        list.add(s);

        for (Object obj : list) {
            System.out.println(obj);
        }

        System.out.println("hello的索引: " + list.indexOf("hello"));

        while (list.contains("hello")) {
            list.remove("hello");
        }

        int index = list.indexOf(123);
        if (index != -1) {
            list.set(index, 1000);
        }
        System.out.println(list);
    }
}
