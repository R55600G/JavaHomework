package cn.henu.software.stu2510250128.ch03;

class LibraryBook {
    private String title;
    private boolean isAvailable;

    public LibraryBook(String title) {
        this.setTitle(title);
        this.setAvailable(true);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class LibraryCard {
    private String cardNumber;
    private boolean isValid;

    public LibraryCard(String cardNumber) {
        this.setCardNumber(cardNumber);
        this.setValid(true);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}

class Student {
    private String name;
    private LibraryCard card;

    public Student(String name, LibraryCard card) {
        this.setName(name);
        this.setCard(card);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LibraryCard getCard() {
        return card;
    }

    public void setCard(LibraryCard card) {
        this.card = card;
    }

    public void borrowBook(LibraryBook book) {
        System.out.println(">>> [" + this.name + "] 拿着借书卡来到前台，准备借阅《" + book.getTitle() + "》...");

        if (this.card == null) {
            System.out.println(this.name + " 没有借到 " + book.getTitle() + "书。（原因：未办理借书卡！）");
            return;
        }

        if (!this.card.isValid()) {
            System.out.println(this.name + " 没有借到 " + book.getTitle() + "书。（原因：借书卡已挂失或失效！）");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println(this.name + " 没有借到 " + book.getTitle() + "书。（原因：手慢了，书已被别人借走！）");
            return;
        }

        book.setAvailable(false);
        System.out.println(this.name + " 借到了 " + book.getTitle() + "书。");
    }
}

public class TestLibrary {
    public static void main(String[] args) {
        System.out.println("========= 系统初始化 =========");
        LibraryBook javaBook = new LibraryBook("Java核心技术");
        LibraryBook mathBook = new LibraryBook("高等数学");

        LibraryCard card1 = new LibraryCard("VIP-001");
        LibraryCard card2 = new LibraryCard("VIP-002");
        card2.setValid(false);

        Student stu1 = new Student("赵云", card1);
        Student stu2 = new Student("马超", card2);
        Student stu3 = new Student("张飞", null);
        System.out.print("初始化完成!");

        System.out.println("\n========= 开始模拟借书场景 =========");

        stu3.borrowBook(mathBook);
        System.out.println("---------------------------------");

        stu2.borrowBook(mathBook);
        System.out.println("---------------------------------");

        stu1.borrowBook(javaBook);
        System.out.println("---------------------------------");

        stu2.getCard().setValid(true);
        stu2.borrowBook(javaBook);
    }
}
