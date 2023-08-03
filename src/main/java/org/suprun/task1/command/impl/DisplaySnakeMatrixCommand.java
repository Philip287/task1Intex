package org.suprun.task1.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.suprun.task1.command.Command;
import org.suprun.task1.entity.Matrix;
import org.suprun.task1.exception.CustomAppException;
import org.suprun.task1.service.ContentApp;
import org.suprun.task1.service.MessageHelper;
import org.suprun.task1.validator.Validator;
import org.suprun.task1.validator.impl.InputNumberValidator;

/**
 * {@code DisplaySnakeMatrixCommand} a class that implements the function of Display Snake Matrix.
 *
 * @author Philip Suprun
 */
public class DisplaySnakeMatrixCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Validator<String> validatorSize = InputNumberValidator.getInstance();

    public DisplaySnakeMatrixCommand() {

    }

    @Override
    public void execute() throws CustomAppException {
        boolean work = true;
        MessageHelper.writeMessage(ContentApp.MESSAGE_QUESTION_ABOUT_MATRIX_SIZE);
        do {
            String userMatrixSize = MessageHelper.readString();
            if (validatorSize.validate(userMatrixSize)) {
                displaySnakeMatrix(userMatrixSize);
                work = false;
            } else {
                MessageHelper.writeMessage(ContentApp.WRONG_MESSAGE);
                LOGGER.error("Incorrect input: " + userMatrixSize);
            }
        } while (work);
    }

    private void displaySnakeMatrix(String userMatrixSize) {

        int matrixSize = Integer.parseInt(userMatrixSize);
        Matrix matrix = new Matrix(matrixSize, matrixSize);

        int row = 0;
        int col = 0;
        int dx = 1;
        int dy = 0;
        int dirChanges = 0;
        int visits = matrixSize;

        for (int index = 0; index < matrixSize * matrixSize; index++) {
            matrix.getMatrix()[row][col] = index + 1;
            if (--visits == 0) {
                visits = matrixSize * (dirChanges % 2) +
                        matrixSize * ((dirChanges + 1) % 2) -
                        (dirChanges / 2 - 1) - 2;
                int temp = dx;
                dx = -dy;
                dy = temp;
                dirChanges++;
            }
            col += dx;
            row += dy;
        }

        matrix.toString();
    }

}
