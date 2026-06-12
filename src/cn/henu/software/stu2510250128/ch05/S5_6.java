package cn.henu.software.stu2510250128.ch05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class S5_6 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate springFestival = LocalDate.of(2025, 1, 29);
        long days = ChronoUnit.DAYS.between(now, springFestival);
        System.out.println("距离蛇年春节还有" + days + "天");
    }
}