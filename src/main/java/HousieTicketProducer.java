import executor.TicketFiller;
import executor.TicketPositionSelector;
import generator.TicketGenerator;
import print.TicketPrinter;

public class HousieTicketProducer {

    public static void main(String[] args) {
        int[][] rawTicket = new TicketGenerator().getTicketSize();
        new TicketPositionSelector().getHalfCookedTicket(rawTicket);
        new TicketFiller().getBakedTicket(rawTicket);
        TicketPrinter.printTicket(rawTicket);
    }
}
