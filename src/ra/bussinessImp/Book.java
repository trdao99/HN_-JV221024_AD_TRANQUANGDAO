package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Book implements IShop,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public static List<Book> bookList = new ArrayList<>();

    @Override
    public void inputData(Scanner sc, List<Author> authorList) {
        Book book = new Book();
        bookList.add(book);
        while (true) {
            try {
                System.out.println("nhập ID sách: ");
                book.bookId = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("ID chỉ có dạng số nguyên");
            }
        }
        System.out.println("nhập tên sách : ");
        book.bookName = sc.nextLine();
        System.out.println("nhập tiêu đề sách : ");
        book.bookName = sc.nextLine();
        while (true) {
            try {
                System.out.println("nhập số trang sách: ");
                book.numberOfPages = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("số trang sách chỉ có dạng số nguyên");
            }
        }
        System.out.println("chọn tác giả(chọn theo ID)");
        for (Author e : authorList) {
            System.out.println(e.toString());
        }
        int IdAuthor;
        boolean exit = true;
        while (true) {
            try {
                IdAuthor = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("ID chỉ có dạng số nguyên");
            }
        }
        for (Author value : authorList) {
            if (value.getAuthorId() == IdAuthor) {
                exit = false;
                book.author = value;
                break;
            }
        }
        if (exit) {
            System.out.println("không có ID này tồn tại.");
        }

        while (true) {
            try {
                System.out.println("giá nhập sách");
                book.importPrice = Float.parseFloat((sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.err.println("giá sách chỉ có dạng số ");
            }
        }
        book.exportPrice = book.importPrice * RATE;
        while (true) {
            try {
                System.out.println("số lượng sách");
                book.quantity = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("số lượng chỉ có dạng số ");
            }
        }
        while (true) {
            try {
                System.out.println("nhập trạng thái sách(true/false): ");
                String status = sc.nextLine().toLowerCase();
                if (status.equals("true") || status.equals("false")) {
                    book.bookStatus = Boolean.parseBoolean(status);
                    break;
                } else {
                    throw new RuntimeException("chỉ nhập true/false");
                }
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }


    }
    public static void sort() {
        Collections.sort(bookList);

    }

    @Override
    public int compareTo(Book o) {
        return Float.compare(this.getExportPrice(), o.getExportPrice());
    }
    @Override
    public String toString() {
        return String.format("ID : %d || Name :%s || Author name : %s || giá bán : %f || số lượng : %d || trạng thái : %s\n", this.bookId, this.bookName, this.author.getAuthorName(), this.exportPrice, this.quantity, this.bookStatus ? "còn hàng" : "hết hàng");
    }

    @Override
    public void displayData() {
        for (Book e : bookList) {
            System.out.println(e.toString());
        }
    }
}
