package cn.henu.software.stu2510250128.ch04;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("取款失败：余额不足！当前余额为 " + balance + " 元，试图取款 " + amount + " 元。");
        }
        balance -= amount;
        System.out.println("取款成功：" + amount + " 元。当前余额为 " + balance + " 元。");
    }
}

public class CustomExceptionTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        try {
            account.withdraw(500.0);
            account.withdraw(800.0);
            account.withdraw(100.0);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}