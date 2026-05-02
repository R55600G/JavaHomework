package cn.henu.software.stu2510250128.ch03;
import java.util.UUID;

class Account {
    private String accountNumber;
    private String accountName;
    private double balance;
    private String password;
    private String recoveryPin;

    public Account(String accountNumber, String accountName, String password, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.password = password;

        // 防止开户时录入负数余额
        if (initialBalance < 0) {
            System.out.println("【系统拦截】开户金额不能为负，已自动修正为 0.0");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }

        // 开户瞬间，调用私有方法在底层生成 PIN 码
        this.recoveryPin = generateComplexPin();

        // 仅在开户时显示一次，绝不提供 get 方法让外界再次查询
        System.out.println("\n****************************************************");
        System.out.println("🎉 开户成功！尊敬的储户 [" + this.accountName + "]");
        System.out.println("⚠️ 【最高机密】系统为您自动生成了唯一的密码恢复 PIN 码：");
        System.out.println("👉 " + this.recoveryPin + " 👈");
        System.out.println("请立即妥善保存！此提示仅展示一次，一旦丢失将无法找回账号！");
        System.out.println("****************************************************\n");
    }

    private String generateComplexPin() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }
    //getter
    public String getAccountNumber() { return accountNumber; }
    public String getAccountName() { return accountName; }
    public double getBalance() { return balance; }
    //账户行为的方法
    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    // 存钱
    public void addBalance(double amount) {
        this.balance += amount;
    }
    //取钱
    public boolean subtractBalance(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true; // 扣款成功
        } else {
            return false; // 余额不足，拒绝扣款
        }
    }
    //重置密码
    public boolean resetPasswordWithPin(String inputPin, String newPassword) {
        // 严格比对外界传来的 PIN 码
        if (this.recoveryPin.equals(inputPin)) {
            this.password = newPassword; // 覆盖旧密码
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private Account[] accountList;
    private int accountCount;
    private Account currentLoggedInAccount;
    public ATM() {
        this.accountList = new Account[10]; // 假设系统容量为 10
        this.accountCount = 0;
        this.currentLoggedInAccount = null; // 初始无人登录
    }
    //录入账户
    public void addAccount(Account acc) {
        if (accountCount < accountList.length) {
            accountList[accountCount] = acc;
            accountCount++;
        }
    }
    //登录
    public void login(String actNo, String pwd) {
        System.out.println("\n>>> 正在验证账号 " + actNo + " ...");
        for (int i = 0; i < accountCount; i++) {
            Account acc = accountList[i];
            if (acc.getAccountNumber().equals(actNo)) {
                // 找到对应账号，请求该账号验证密码
                if (acc.verifyPassword(pwd)) {
                    this.currentLoggedInAccount = acc; // 【状态切换】：锁定当前登录用户
                    System.out.println("✅ 登录成功！欢迎您，" + acc.getAccountName());
                    return;
                } else {
                    System.out.println("❌ 登录失败：密码错误！");
                    return;
                }
            }
        }
        System.out.println("❌ 登录失败：该账号不存在！");
    }
    //存钱
    public void deposit(double amount) {
        // 安检拦截：未登录绝不允许操作
        if (this.currentLoggedInAccount == null) {
            System.out.println("【非法操作】请先插卡登录！");
            return;
        }
        if (amount <= 0) {
            System.out.println("【操作失败】存款金额必须大于 0！");
            return;
        }

        // 命令当前登录的账户自己去加钱
        this.currentLoggedInAccount.addBalance(amount);
        System.out.println("💰 成功存入: ￥" + amount + "。当前余额: ￥" + this.currentLoggedInAccount.getBalance());
    }
    //取钱
    public void withdraw(double amount) {
        // 安检拦截：未登录绝不允许操作
        if (this.currentLoggedInAccount == null) {
            System.out.println("【非法操作】请先插卡登录！");
            return;
        }
        if (amount <= 0) {
            System.out.println("【操作失败】取款金额必须大于 0！");
            return;
        }

        // 命令当前登录的账户尝试扣款
        boolean success = this.currentLoggedInAccount.subtractBalance(amount);
        if (success) {
            System.out.println("💵 成功取出: ￥" + amount + "。当前余额: ￥" + this.currentLoggedInAccount.getBalance());
        } else {
            System.out.println("【操作失败】余额不足！您的当前余额为: ￥" + this.currentLoggedInAccount.getBalance());
        }
    }
    //退卡
    public void logout() {
        if (this.currentLoggedInAccount != null) {
            System.out.println("👋 账号 " + this.currentLoggedInAccount.getAccountNumber() + " 已安全退出，请取走您的卡片。");
            this.currentLoggedInAccount = null; // 恢复空闲状态
        }
    }
    //忘记密码
    public void forgotPassword(String actNo, String pinInput, String newPwd) {
        System.out.println("\n>>> 启动紧急密码重置程序 (账号: " + actNo + ") ...");
        for (int i = 0; i < accountCount; i++) {
            Account acc = accountList[i];
            if (acc.getAccountNumber().equals(actNo)) {
                // 账号存在，将用户输入的 PIN 交给账户进行底层比对
                boolean success = acc.resetPasswordWithPin(pinInput, newPwd);
                if (success) {
                    System.out.println("✅ PIN 码验证通过！密码重置成功，请使用新密码重新登录。");
                } else {
                    System.out.println("❌ 警告：PIN 码不匹配！拒绝重置密码，已记录本次异常攻击！");
                }
                return;
            }
        }
        System.out.println("❌ 操作失败：该账号不存在！");
    }
}

// ================= 3. 测试主类 =================
public class TestATM {
    public static void main(String[] args) {
        System.out.println("================= 银行后台系统启动 =================");
        ATM myATM = new ATM();

        // 测试开户
        Account acc1 = new Account("62220001", "周杰伦", "123456", 5000.0);
        Account acc2 = new Account("62220002", "林俊杰", "888888", 200.0);

        myATM.addAccount(acc1);
        myATM.addAccount(acc2);
        System.out.println("================= ATM 终端部署完毕 =================\n");

        System.out.println("--- 场景1：黑客企图绕过登录直接拿钱 ---");
        myATM.withdraw(100);

        System.out.println("\n--- 场景2：正常的存取款业务流程 ---");
        myATM.login("62220001", "123456"); // 登录周杰伦账号
        myATM.deposit(2000);   // 存钱
        myATM.withdraw(8000);  // 尝试透支
        myATM.withdraw(1500);  // 正常取钱
        myATM.logout();        // 退卡

        System.out.println("\n--- 场景3：黑客企图暴力重置别人的密码 ---");
        // 随便猜一个 PIN 码去攻击
        myATM.forgotPassword("62220001", "WRONGPIN1234", "999999");

        // --- 场景4：合法的密码找回流程 ---
        // myATM.forgotPassword("62220001", "在这里填入控制台打印的真实PIN码", "654321");
        // myATM.login("62220001", "654321"); // 使用新密码重新登录测试
    }
}
