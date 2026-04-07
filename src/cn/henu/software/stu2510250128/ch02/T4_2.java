package cn.henu.software.stu2510250128.ch02;

public class T4_2 {

    // 求两个整数的最大值
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 求两个小数的最大值
    public static double max(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 求三个小数的最大值
    public static double max(double a, double b, double c) {
        double tempMax = max(a, b);
        return max(tempMax, c);
    }

    public static void main(String[] args) {
        System.out.println("--- 方法重载测试 ---");

        int maxInt = max(15, 28);
        System.out.println("两个整数 15 和 28 的最大值是：" + maxInt);

        double maxDouble2 = max(3.14, 2.71);
        System.out.println("两个小数 3.14 和 2.71 的最大值是：" + maxDouble2);

        double maxDouble3 = max(1.5, 9.9, 4.2);
        System.out.println("三个小数 1.5, 9.9, 4.2 的最大值是：" + maxDouble3);
    }
}