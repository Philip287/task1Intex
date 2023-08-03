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

import static java.lang.Math.min;


/**
 * {@code DisplayPyramidMatrixCommand} a class that implements the function of Display Pyramid Matrix.
 *
 * @author Philip Suprun
 */

public class DisplayPyramidMatrixCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Validator<String> validatorSize = InputNumberValidator.getInstance();

    public DisplayPyramidMatrixCommand() {
    }

    @Override
    public void execute() throws CustomAppException {
        boolean work = true;
        MessageHelper.writeMessage(ContentApp.MESSAGE_QUESTION_ABOUT_MATRIX_SIZE);
        do {
            String userMatrixSize = MessageHelper.readString();
            if (validatorSize.validate(userMatrixSize)) {
                displayPyramidMatrix(userMatrixSize);
                work = false;
            } else {
                MessageHelper.writeMessage(ContentApp.WRONG_MESSAGE);
                LOGGER.error("Incorrect input: " + userMatrixSize);
            }
        } while (work);
    }

    private void displayPyramidMatrix(String userMatrixSize) {
        int matrixSize = Integer.parseInt(userMatrixSize) / 2;
        Matrix matrix = new Matrix(matrixSize * 2, matrixSize * 2);

        for (int index1 = 0; index1 < matrix.getMatrix().length; index1++) {
            int[] miniArr = matrix.getMatrix()[index1];
            for (int index2 = 0; index2 < miniArr.length; index2++) {

                int ii = (index1 < matrixSize) ? min(index1, index2) : min(index2, matrixSize * 2 - index1 - 1);
                int ij = (index2 < matrixSize) ? min(index1, index2) : min(index1, matrixSize * 2 - index2 - 1);

                miniArr[index2] = min(ii, ij);
            }
        }

        matrix.toString();
    }
}
