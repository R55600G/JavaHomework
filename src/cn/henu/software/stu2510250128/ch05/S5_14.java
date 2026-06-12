package cn.henu.software.stu2510250128.ch05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class S5_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            int num = sc.nextInt();
            if (num == 0) break;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (int freq : map.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                System.out.println(entry.getKey());
            }
        }
    }
}
