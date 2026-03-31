package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

public class T1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入若干个数,每一个数回车确认");
        System.out.println("最后输入数字0结束输入操作");
        double sum=0.0;
        while (true){
            double t;
            t=sc.nextDouble();
            if (t!=0){
                sum+=t;
            }
            else{
                System.out.println("sum="+sum);
                break;
            }

        }
        sc.close();
    }
}