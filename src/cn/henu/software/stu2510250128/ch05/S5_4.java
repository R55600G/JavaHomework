package cn.henu.software.stu2510250128.ch05;

import java.util.Scanner;

public class S5_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuffer sb1 = new StringBuffer(input);
        System.out.println(sb1.reverse().toString());

        String[] arr = {"Hello", "World", "Java"};

        String sResult = "";
        for (String s : arr) {
            sResult += s;
        }
        System.out.println(sResult);

        StringBuffer sb2 = new StringBuffer();
        for (String s : arr) {
            sb2.append(s);
        }
        System.out.println(sb2.toString());
    }
}
