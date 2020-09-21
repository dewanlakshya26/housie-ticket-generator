package generator;

import java.util.Scanner;

public class TicketGenerator {

    public int[][] getTicketSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of rows");
        while (!sc.hasNextInt()) {
            System.out.println("please enter a numeral value");
            sc.next();
        }
        int noOfRows = sc.nextInt();
        System.out.println("enter no of columns");
        while (!sc.hasNextInt()) {
            System.out.println("please enter a numeral value");
            sc.next();
        }
        int noOfColumns = sc.nextInt();
        return new int[noOfRows][noOfColumns];
    }


}
