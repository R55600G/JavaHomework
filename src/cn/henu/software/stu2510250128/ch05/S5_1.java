package cn.henu.software.stu2510250128.ch05;

import java.util.Scanner;

public class S5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("明文：");
        String text = sc.nextLine();
        System.out.println("****************************************");
        System.out.println("加密方法：每个字符的ASCII码加1");
        System.out.println("****************************************");

        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            cipher.append((char) (text.charAt(i) + 1));
        }
        System.out.println("密文：" + cipher);
        System.out.println("****************************************");

        StringBuilder plain = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            plain.append((char) (cipher.charAt(i) - 1));
        }
        System.out.println("解密：" + plain);
    }
}
