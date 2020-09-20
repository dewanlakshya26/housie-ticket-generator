package print;

public class TicketPrinter {
    public static void printTicket(int[][] ticket) {
        System.out.println();
        System.out.println("\033[0;1m" + "*******   TICKET IS GENERATED   *******");
        System.out.println();
        for (int i = 0; i < ticket.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < ticket[0].length; j++) {
                if (ticket[i][j] == 0) {
                    System.out.print("  ");
                } else if (j < ticket[0].length - 1) {
                    System.out.print( ticket[i][j] + " ");
                } else
                    System.out.print(" " + ticket[i][j]);
            }
            System.out.println(" ]");
        }

    }

}
