package cn.henu.software.stu2510250128.ch02;

public class T3_2 {
    public static void main(String[] args) {
        int forward = 4;
        int back = 1;
        int distance = 0;
        int i = 0;
        while (distance < 100) {
            i++;
            distance += forward;
            if (distance >= 100)
                break;
            distance -= back;

        }
        System.out.println("花费" + i + "小时");
    }
}
