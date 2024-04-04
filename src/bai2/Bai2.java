package bai2;

import ra.bussinessImp.Book;

import java.util.Scanner;
import java.util.Stack;

public class Bai2 {
    static Stack<String> stringStack = new Stack<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        out:
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập URL muốn truy cập\n" +
                    "2. Quay lại\n" +
                    "3. Thoát\n");
            System.out.println("chọn chức năng");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    input(sc);
                    break;
                case 2:
                    returnn();
                    break;
                case 3:
                    break out;
            }
        }
    }

    public static void input(Scanner sc) {
        System.out.print("nhập URL:");
        String URL = sc.nextLine();
        stringStack.push(URL);
    }

    public static void returnn() {
        stringStack.pop();
        System.out.println(stringStack.peek());
    }
}