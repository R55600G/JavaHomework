package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

public class T5_1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5};
        System.out.println("数组中元素有");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();


        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要查找的数");
        int count = 0;
        int a = scan.nextInt();
        System.out.println("查找结果：数字" + a + "出现在下标");
        for (int i = 0; i < arr.length; i++) {
            if (a == arr[i]) {
                System.out.print(i + " ");
                count++;
            }
        }
        if (count == 0)
            System.out.println("错误,没找到");
        scan.close();
    }
}
