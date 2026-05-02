package cn.henu.software.stu2510250128.ch03;

class Book {
    private String bookNo;
    private String bookTitle;
    private String author;
    private int yearPublished;

    public Book(String bookNo, String bookTitle, String author, int yearPublished) {
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.author = author;
        //this.yearPublished = yearPublished; 我感觉不安全，于是写了下面的让年份赋值更安全的方法.
        this.modifyYearPublished(yearPublished);
    }

    public void showBookNo() {
        System.out.println("书号" + bookNo);
    }

    public void showBookTitle() {
        System.out.println("书名" + bookTitle);
    }

    public void showAuthor() {
        System.out.println("书号" + author);
    }

    public void showYearPublished() {
        System.out.println("书号" + yearPublished);
    }

    public void modifyYearPublished(int newYear) {
        if (newYear < 1450 || newYear > 2026) {
            System.out.println("【安全拦截】您输入的年份 (" + newYear + ") 不合理！已自动重置为默认年份 2024。");
            this.yearPublished = 2024;
        } else {
            this.yearPublished = newYear;
            System.out.println("更改出版年份成功！");
        }
    }

}

public class S3_1 {
    public static void main(String[] args) {
        Book b1 = new Book("ISBN123456789", "Java Programming", "John Doe", 2024);
        Book b2 = new Book("ISBN987654321", "Data Structures", "Jane Smith", 2023);

        System.out.println("以下是b1的信息");
        b1.showBookNo();
        b1.showBookTitle();
        b1.showAuthor();
        b1.showYearPublished();
        System.out.println();

        System.out.println("以下是b2的信息");
        b2.showBookNo();
        b2.showBookTitle();
        b2.showAuthor();
        b2.showYearPublished();
        System.out.println();

        System.out.println("修改b1出版年份后");
        b1.modifyYearPublished(2021);
        System.out.print("修改后的 b1 ");
        b1.showYearPublished();
        System.out.println();

        System.out.println("测试安全防御网");
        b1.modifyYearPublished(-999);
        System.out.print("非法修改后的 b1 ");
        b1.showYearPublished();
    }
}