package cn.henu.software.stu2510250128.ch05;

import java.util.HashMap;
import java.util.Map;

public class S5_16 {
    public static void main(String[] args) {
        String s = "Today, We have a class of java, as we kown, java is an object oriented  programming language, and java is fun! wish you enjoy it!";
        String[] words = s.split("[ \n\t\r.,;:!?()]+");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                String w = word.toLowerCase();
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
