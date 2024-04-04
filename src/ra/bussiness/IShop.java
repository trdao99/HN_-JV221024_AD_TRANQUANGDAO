package ra.bussiness;

import ra.bussinessImp.Author;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE = 1.3F;
    void inputData(Scanner sc, List<Author> authorList);

    void displayData();

}
