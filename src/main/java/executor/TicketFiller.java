package executor;

import java.util.Random;
import java.util.logging.Logger;

import static executor.TicketPositionSelector.getConstraint;

public class TicketFiller {
    Random random = new Random();
    Logger logger = Logger.getLogger(TicketFiller.class.getName());
    private int dummyValue = getConstraint("ticket.dummy.value");

    public void getBakedTicket(int[][] rawTicket) {
        logger.info("printing random numbers starting...");
        for (int i = 0; i < rawTicket.length; i++) {
            for (int j = 0; j < rawTicket[0].length; j++) {
                if (rawTicket[i][j] == dummyValue)
                    rawTicket[i][j] = getRandomNumberUsingInts(j);
            }
        }
        logger.info("printing random numbers completed.");
    }

    public int[] getRangeForNumber(int number) {
        if (number > 9) {
            number = number / 10;
        }

        switch (number) {
            case 0:
                return new int[]{0, 11};
            case 1:
                return new int[]{11, 21};
            case 2:
                return new int[]{21, 31};
            case 3:
                return new int[]{31, 41};
            case 4:
                return new int[]{41, 51};
            case 5:
                return new int[]{51, 61};
            case 6:
                return new int[]{61, 71};
            case 7:
                return new int[]{71, 81};
            case 8:
                return new int[]{81, 91};
            case 9:
                return new int[]{91, 101};
        }
        return new int[]{91, 101};

    }

    public int getRandomNumberUsingInts(int number) {
        int[] range = getRangeForNumber(number);
        return random.ints(range[0], range[1])
                .findFirst()
                .getAsInt();
    }
}
