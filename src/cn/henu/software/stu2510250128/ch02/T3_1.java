package cn.henu.software.stu2510250128.ch02;

public class T3_1 {
    public static void main(String[] args) {
        //for
        double sum1 = 1;
        double fac1 = 1;
        for (int i = 2; i <= 20; i++) {
            fac1 *= i;
            if (i % 2 == 0)
                sum1 += 1 / fac1;
            else
                sum1 -= 1 / fac1;
        }
        System.out.println(sum1);
        //do-while
        double sum2 = 1;
        double fac2 = 1;
        int j = 2;
        do {
            fac2 *= j;
            if (j % 2 == 0)
                sum2 += 1 / fac2;
            else
                sum2 -= 1 / fac2;
            j++;
        }
        while (j <= 20);
        System.out.println(sum2);
    }
}
