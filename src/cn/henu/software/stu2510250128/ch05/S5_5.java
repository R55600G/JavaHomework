package cn.henu.software.stu2510250128.ch05;

import java.util.Random;
import java.util.Scanner;

public class S5_5 {
    public static void main(String[] args) {
        String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            code.append(pool.charAt(r.nextInt(pool.length())));
        }
        System.out.println("生成的验证码：" + code);

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (code.toString().equalsIgnoreCase(input)) {
            System.out.println("恭喜验证成功！");
        } else {
            System.out.println("验证失败！");
        }
    }
}