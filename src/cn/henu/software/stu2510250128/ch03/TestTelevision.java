package cn.henu.software.stu2510250128.ch03;

class Television {
    // ================== 1. 静态属性与方法 ==================
    private static int idCounter = 1000;

    // 统计生产的总台数
    private static int totalProduced = 0;

    // 静态方法：控制和操纵静态成员变量
    // 每次调用，负责生成一个新的流水号，并让总产量+1
    private static int generateNextId() {
        totalProduced++;
        idCounter++;
        return idCounter;
    }

    public static void showProductionStats() {
        System.out.println("【出厂统计】目前流水线共生产了 " + totalProduced + " 台电视机，下一个预分配编号为: " + (idCounter + 1));
    }

    // ================== 2. 实例属性 ==================
    private int id;             // 商品编号
    private boolean isOn;       // 开关状态 (true为开，false为关)
    private int volume;         // 音量 (假设范围 0-100)
    private int channel;        // 频道 (假设范围 1-999)

    // ================== 3. 构造方法 ==================
    public Television() {
        // 调用静态方法获取独一无二的编号，赋值给当前对象的 id
        this.id = generateNextId();

        // 默认出厂状态：关机，音量20，频道1
        this.isOn = false;
        this.setVolume(20);
        this.setChannel(1);
    }

    // ================== 4. 电视机控制方法 ==================

    // 只能获取商品编号，不能提供 setId 方法，防止出厂后被乱改
    public int getId() {
        return id;
    }

    // 电源开关控制
    public void togglePower() {
        this.isOn = !this.isOn; // 状态反转
        if (this.isOn) {
            System.out.println("📺 电视机 [编号:" + this.id + "] 已开机。");
        } else {
            System.out.println("📺 电视机 [编号:" + this.id + "] 已关机。");
        }
    }

    // 设置频道
    public void setChannel(int channel) {
        if (!this.isOn) {
            System.out.println("【操作失败】电视未开机，无法更换频道！");
            return;
        }

        if (channel < 1 || channel > 999) {
            System.out.println("【警告】频道 " + channel + " 是无效频道！(范围:1-999)");
        } else {
            this.channel = channel;
            System.out.println("📺 已切换至频道: " + this.channel);
        }
    }

    // 频道加 1
    public void channelUp() {
        this.setChannel(this.channel + 1);
    }

    // 频道减 1
    public void channelDown() {
        this.setChannel(this.channel - 1);
    }

    // 设置音量
    public void setVolume(int volume) {
        if (!this.isOn && this.id != 0) { // 排除刚出厂初始化的情况
            System.out.println("【操作失败】电视未开机，无法调节音量！");
            return;
        }

        if (volume < 0) {
            System.out.println("【警告】音量已达最小！");
            this.volume = 0;
        } else if (volume > 100) {
            System.out.println("【警告】音量已达最大！");
            this.volume = 100;
        } else {
            this.volume = volume;
            if (this.isOn) {
                System.out.println("🔊 当前音量: " + this.volume);
            }
        }
    }

    // 音量加
    public void volumeUp() {
        this.setVolume(this.volume + 5); // 假设每次加 5
    }

    // 音量减
    public void volumeDown() {
        this.setVolume(this.volume - 5);
    }

    // 显示当前状态
    public void showStatus() {
        System.out.println("------------------------------------");
        System.out.println("商品编号: " + this.id);
        System.out.println("电源状态: " + (this.isOn ? "🟢 开机" : "⚫ 关机"));
        if (this.isOn) {
            System.out.println("当前频道: " + this.channel);
            System.out.println("当前音量: " + this.volume);
        }
        System.out.println("------------------------------------");
    }
}

// ================= 测试类 =================
public class TestTelevision {
    public static void main(String[] args) {
        System.out.println("======= 1. 电视机出厂测试 =======");
        Television tv1 = new Television();
        Television tv2 = new Television();
        Television tv3 = new Television();

        // 查看全局生产数据
        Television.showProductionStats();

        System.out.println("\n======= 2. 状态拦截测试 (关机状态下操作) =======");
        tv1.showStatus();
        tv1.setChannel(5); // 应该被拦截
        tv1.volumeUp();    // 应该被拦截

        System.out.println("\n======= 3. 正常开机操作测试 =======");
        tv1.togglePower(); // 按下开关
        tv1.showStatus();

        tv1.setChannel(8); // 正常换台
        tv1.channelUp();   // 换到 9 台

        // 测试音量边界限制
        tv1.setVolume(98);
        tv1.volumeUp();    // 尝试调到 103，应该被拦截并固定在 100

        tv1.showStatus();

        System.out.println("\n======= 4. 验证多台电视的自动编号 =======");
        tv2.togglePower();
        tv2.showStatus();  // 应该显示编号为 1002
    }
}