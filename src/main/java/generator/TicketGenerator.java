package generator;

import java.util.Scanner;

public class TicketGenerator {

    public int[][] getTicketSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of rows");
        int noOfRows = sc.nextInt();
        System.out.println("enter no of columns");
        int noOfColumns = sc.nextInt();
        return new int[noOfRows][noOfColumns];
    }


}
