package cn.henu.software.stu2510250128.ch05;

import java.util.Scanner;

public class S5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文");
        String text = sc.nextLine();
        System.out.println("加密方法：每个字符的ASCII码加1");
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char encryptedChar=(char)(c+1);
            cipher.append(encryptedChar);
        }
        System.out.println("密文"+cipher.toString());
    }
}
