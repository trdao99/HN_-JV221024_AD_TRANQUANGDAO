package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public static List<Author> authorList = new ArrayList<>();
    @Override
    public void inputData(Scanner sc, List<Author> authorList) {
        Author author = new Author();
        authorList.add(author);
        while (true) {
            try {
                System.out.println("nhập ID tác giả: ");
                author.authorId = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("ID chỉ có dạng số nguyên");
            }
        }
        System.out.println("nhập tên tác giả: ");
        author.authorName = sc.nextLine();
        while (true) {
            try {
                System.out.println("nhập giới tính tác giả(true-Nam/false-Nữ): ");
                String sexx = sc.nextLine().toLowerCase();
                if (sexx.equals("true") || sexx.equals("false")) {
                    author.sex = Boolean.parseBoolean(sexx);
                    break;
                } else {
                    throw new RuntimeException("chỉ nhập true/false");
                }
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("nhập năm sinh tác giả: ");
                author.year = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("năm sinh chỉ có dạng số nguyên");
            }
        }

    }

    @Override
    public String toString() {
        return String.format( "ID :%d || Name : %s || Sex : %s\n", this.authorId, this.authorName, this.sex ? "Nam" : "Nữ");
    }

    @Override
    public void displayData() {
        for (Author e : authorList) {
            System.out.println(e.toString());
        }
    }
}
