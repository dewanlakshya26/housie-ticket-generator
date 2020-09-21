package executor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

public class TicketPositionSelector {

    Logger logger = Logger.getLogger(TicketFiller.class.getName());
    private int columsConstraint = getConstraint("ticket.column.constratnt");
    private int dummyValue = getConstraint("ticket.dummy.value");
    Random randomIndexGenerator = new Random();


    public int[][] getHalfCookedTicket(int[][] rawTicket) {
        logger.info("selecting positions for random numbers");
        int[][] dupligateRawTicket = rawTicket.clone();
        int primary = (int) (Math.random() * rawTicket.length);
        logger.info("primary position is" + primary);
        int[][] slaveArray = getSlaveArray(dupligateRawTicket, primary);
        for (int[] row : slaveArray) {
            populatSlaveRow(row);
        }
        populateMasterArray(rawTicket, primary, slaveArray);
        logger.info("random numbers position operation completed");
        return new int[2][2];
    }

    private void populateMasterArray(int[][] rawTicket, int primary, int[][] slaveArray) {
        int row_length = rawTicket.length;
        int column_length = rawTicket[0].length;
        int count = 0;
        for (int i = 0; i < row_length - 2; i++) {
            for (int j = 0; j < column_length; j++) {
                if (!(slaveArray[i][j] == dummyValue && slaveArray[i + 1][j] == dummyValue) && count < columsConstraint) {
                    rawTicket[primary][j] = dummyValue;
                    count++;
                }
            }
        }
    }

    private int[][] getSlaveArray(int[][] scratchArray, int primary) {
        scratchArray[primary] = scratchArray[scratchArray.length - 1];
        return Arrays.copyOf(scratchArray, scratchArray.length - 1);

    }

    private void populatSlaveRow(int[] row) {
        int rowLength = row.length;
        HashSet<Integer> randomValues = new HashSet<>();
        while (randomValues.size() < columsConstraint) {
            randomValues.add(generateRandomIndexes(rowLength, randomIndexGenerator));
        }
        randomValues.forEach(randomIndex -> row[randomIndex] = dummyValue);
    }

    private Integer generateRandomIndexes(int rowLength, Random randomIndexGenerator) {
        return randomIndexGenerator.nextInt(rowLength);
    }


    static int getConstraint(String constraint) {
        Logger.getLogger(TicketFiller.class.getName()).info("fetching config values from seed.");
        try (InputStream input = new FileInputStream(new File("").getAbsolutePath() + "/src/main/resources/application.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            return Integer.parseInt(prop.getProperty(constraint));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
