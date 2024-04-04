package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.Collections;
import java.util.Scanner;

import static ra.bussinessImp.Author.authorList;
import static ra.bussinessImp.Book.bookList;


public class BookManagement {
    static Author author = new Author();
    static Book book = new Book();

    public static void main(String[] args) {

        out:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả \n" +
                    "2. Nhập số sách và nhập thông tin các sách \n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách \n" +
                    "5. Thoát\n");
            System.out.println(" ");
            System.out.println("chọn chức năng");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    addAuthor(sc);
                    break;
                case 2:
                    addBooks(sc);
                    break;
                case 3:
                    Book.sort();
                    book.displayData();
                    break;
                case 4:
                    search(sc);
                    break;
                case 5:
                    break out;
            }
        }
    }

    public static void addAuthor(Scanner sc) {
        while (true) {
            try {
                System.out.println("số tác giả muốn thêm: ");
                int count = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < count; i++) {
                    author.inputData(sc, authorList);
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("số tác giả chỉ có dạng số nguyên");
            }
        }
    }

    public static void addBooks(Scanner sc) {
        while (true) {
            try {
                System.out.println("số sách muốn thêm: ");
                int count = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < count; i++) {
                    book.inputData(sc, authorList);
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("số sách chỉ có dạng số nguyên");
            }
        }
    }
    public static void search(Scanner sc){
        while (true) {
            boolean exit = true;
            try {
                System.out.println("nhập tên tác giả muốn tìm: ");
                String author = sc.nextLine().toLowerCase();
                for (Book e : bookList) {
                    if (e.getAuthor().getAuthorName().toLowerCase().equals(author)) {
                        exit = false;
                        System.out.println(e.toString());
                    }
                }
                if (exit) {
                    throw new RuntimeException("Tác giả không tồn tại");
                }
                break;
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
