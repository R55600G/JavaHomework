package cn.henu.software.stu2510250128.ch04;

class UnderageException extends Exception {
    public UnderageException() {

    }

    public UnderageException(String message) {
        super(message);
    }
}

class InternetCafe {
    public void checkAge(int age) throws UnderageException {
        if (age < 18) {
            throw new UnderageException("警告：未满18岁，禁止入内上网！");
        }
        System.out.println("年龄 " + age + " 岁，验证通过，机器已开机。");
    }
}

public class ExceptionTest {
    static void main(String[] args) {
        InternetCafe internetCafe1=new InternetCafe();
        try {
            internetCafe1.checkAge(18);
            internetCafe1.checkAge(20);
            internetCafe1.checkAge(16);
        }catch (UnderageException e) {
            System.out.println(e.getMessage());
        }
    }
}
