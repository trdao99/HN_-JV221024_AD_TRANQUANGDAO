package bai3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai3 {
    static Queue<String> stringQueue = new LinkedList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        out:
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên khách hàng chờ mua vé xem phim\n" +
                    "2. Khách tiếp theo\n" +
                    "3. Thoát\n");
            System.out.println("chọn chức năng");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    input(sc);
                    break;
                case 2:
                    next();
                    break;
                case 3:
                    break out;
            }
        }
    }
    public static void input(Scanner sc) {
        System.out.print("nhập tên khách:");
        String kh = sc.nextLine();
        stringQueue.add(kh);
    }
    public static void next() {
        System.out.println(stringQueue.poll());
    }
}
