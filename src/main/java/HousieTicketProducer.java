import executor.TicketFiller;
import executor.TicketPositionSelector;
import generator.TicketGenerator;
import print.TicketPrinter;

import java.util.Arrays;

public class HousieTicketProducer {

    public static void main(String[] args) {
        int [][] rawTicket = new TicketGenerator().getTicketSize();
         new TicketPositionSelector().getHalfCookedTicket(rawTicket);
        new TicketFiller().execute(rawTicket);
        TicketPrinter.printTicket(rawTicket);
    }
}
