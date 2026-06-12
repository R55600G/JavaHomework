package cn.henu.software.stu2510250128.ch04;

class HenuStudent {
    public final String university_name = "Henu";
    public String name;

    public HenuStudent(String name) {
        this.name = name;
    }

    public final void speakMotto() {
        System.out.println(name + "说:明德新民，止于至善");
    }

    public void study() {
        System.out.println(name + "正在学习公共课");
    }
}

class SoftwareEngineeringStudent extends HenuStudent {

    public SoftwareEngineeringStudent(String name) {
        super(name);
    }

/*  public void changeUniversityName() {
        this.university_name = "北京大学";
    }
*/
/*
    @Override
    public void speakMotto() {
        System.out.println("加油HUAWEI，加油China！");
    }
    java: cn.henu.software.stu2510250128.ch04.SoftwareEngineeringStudent中的speakMotto()无法覆盖cn.henu.software.stu2510250128.ch04.HenuStudent中的speakMotto()
  被覆盖的方法为final
*/

    @Override
    public void study() {
        System.out.println(name + "正在学习Java");
    }
}

final class FreshmanOf2025 extends SoftwareEngineeringStudent {

    public final String CAMPUS = "明伦校区";

    public FreshmanOf2025(String name) {
        super(name);
    }

    public void showInfo() {
        System.out.println("我是 2025 级的软件工程新生，目前在 " + CAMPUS + " 学习！");
    }
}

/*class TryToExtendFreshman extends FreshmanOf2025 {
    public TryToExtendFreshman(String name) {
        super(name);
    }
}
java: 无法从最终cn.henu.software.stu2510250128.ch04.FreshmanOf2025进行继承
*/

public class HenuFinalTest {
    public static void main(String[] args) {
        System.out.println("final变量测试程序==============");
        FreshmanOf2025 me = new FreshmanOf2025("李明");
        System.out.println("就读学校" + me.university_name);

        System.out.println("final方法测试程序=============");
        me.speakMotto();

        System.out.println("重写的方法测试程序==============");
        me.study();

        System.out.println("final类测试程序================");
        me.showInfo();
    }
}
