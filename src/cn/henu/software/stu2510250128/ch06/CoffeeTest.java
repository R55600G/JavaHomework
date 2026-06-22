package cn.henu.software.stu2510250128.ch06;

class MilkExpiredException extends Exception {
    public MilkExpiredException(String message) {
        super(message);
    }
}

class CoffeeShop {
    public void makeCoffee(boolean isMilkFresh) throws MilkExpiredException {
        System.out.println("店员：好的，开始为您制作咖啡...");
        if (!isMilkFresh) {
            throw new MilkExpiredException("牛奶过期了，做不了咖啡！");
        }
        System.out.println("店员：咖啡做好了，请慢用！");
    }
}

public class CoffeeTest {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        System.out.println("=== 欢迎光临咖啡店 ===");
        try {
            System.out.println("【我】：你好，点一杯拿铁。");
            coffeeShop.makeCoffee(false);
            System.out.println("【我】：开心喝咖啡。");
        } catch (MilkExpiredException e) {
            System.out.println("【意外发生】: " + e.getMessage());
        } finally {
            System.out.println("【最终动作】：离开柜台，给后面排队的人让出位置。");
        }
        System.out.println("=== 走出咖啡店 ===");
    }

}
