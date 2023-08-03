package org.suprun.task1.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.suprun.task1.exception.CustomAppException;

/**
 * {@code Operation} enum is used to choose type of operation
 *
 * @author Philip Suprun
 */
public enum Operation {
    INFO,    //to look at information about bank account
    SNAKE_MATRIX, //to put money to bank account
    PYRAMID_MATRIX,//to take money
    EXIT;    //to exit from atm emulator; user may finish application by writing word "exit" before any command

    private static final Logger LOGGER = LogManager.getLogger();

    public static Operation getAllowableOperationByOrdinal(Integer i) throws CustomAppException {
        switch (i) {
            case 1:
                return Operation.INFO;
            case 2:
                return Operation.SNAKE_MATRIX;
            case 3:
                return Operation.PYRAMID_MATRIX;
            case 4:
                return Operation.EXIT;
            default:
                LOGGER.info(ContentApp.MESSAGE);
                throw new CustomAppException(ContentApp.MESSAGE);
        }
    }
}
