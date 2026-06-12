package cn.henu.software.stu2510250128.ch04;

import java.util.Random;

interface Staff {
    int getSalary();
}

class Member {
    protected int fee = 1500;

    public int getFee() {
        return fee;
    }
}

class PartTimeMember extends Member implements Staff {
    private int salary;

    public PartTimeMember() {
        Random random = new Random();
        this.salary = random.nextInt(2001) + 1000;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public void calculateNetIncome() {
        int netIncome = salary - fee;

        System.out.println("兼职会员本月工资为: " + salary + " 元");
        System.out.println("兼职会员本月需交会费: " + fee + " 元");
        System.out.println("-------------------------");

        if (salary < fee) {
            System.out.println("本月净收入为: " + netIncome + " 元");
            System.out.println("工资不够交会费啦，加油干吧！");
        } else {
            System.out.println("本月净收入为: " + netIncome + " 元。本月有结余！");
        }
    }
}

public class ClubManagementTest {
    public static void main(String[] args) {
        System.out.println("=== 俱乐部兼职会员结算系统 ===");
        PartTimeMember ptm = new PartTimeMember();
        ptm.calculateNetIncome();
    }
}
