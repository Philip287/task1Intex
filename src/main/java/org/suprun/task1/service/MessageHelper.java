package org.suprun.task1.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.suprun.task1.exception.CustomAppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@code MessageHelper} class is used to display messages in App monitor
 *
 * @author Philip Suprun
 */
public class MessageHelper {

    private static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    private static final Logger LOGGER = LogManager.getLogger();

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws CustomAppException {
        String line;
        try {
            line = bufferReader.readLine();
        } catch (IOException e) {
            LOGGER.error("Exception in MessageHelper.readString() method find ", e);
            throw new CustomAppException(e);
        }

        return line;
    }

    public static Operation askOperation() {
        boolean exit = false;
        while (!exit) {
            try {
                writeMessage(ContentApp.MESSAGE);
                int operationType = Integer.parseInt(readString());
                exit = true;
                return Operation.getAllowableOperationByOrdinal(operationType);
            } catch (NumberFormatException | CustomAppException e) {
                LOGGER.error("Exception in MessageHelper.askOperation() method find ", e);
                MessageHelper.writeMessage(ContentApp.UNKNOWN_OPERATION_MESSAGE);
            }
        }
        return askOperation();
    }

}
