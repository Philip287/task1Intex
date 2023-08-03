package org.suprun.task1.service;

/**
 * {@code ContentApp} class is used to localization messages in App monitor
 *
 * @author Philip Suprun
 */
public class ContentApp {
    public static final String MESSAGE = "Enter operation type, please: \n 1 - INFO. \n 2 - Display on the screen " +
            "SNAKE MATRIX." +
            "\n 3 - Display on the screen PYRAMID MATRIX.\n 4 - EXIT.";
    public static final String UNKNOWN_OPERATION_MESSAGE = "Unknown operation, try again";
    public static final String QUESTION_EXIT_MESSAGE = "Do you want to exit o continue? \n" +
            "Enter: \n 1 if you want to exit. \n 2 if you want to continue.";
    public static final String CHOICE_1 = "1";
    public static final String CHOICE_2 = "2";
    public static final String WRONG_MESSAGE = "Incorrect input. Try again.";
    public static final String MESSAGE_INFO = "The Matrix Imagers program is designed to create and display two kinds " +
            "of square matrices, up to 20 squares in size, on the screen of your device. \n" +
            "\n" +
            "This program can:\n" +
            "- output to the console 2 square matrices: snake and pyramid (view \n" +
            "from above).\n" +
            "- It is possible to choose the size of the matrix from 1 to 20 cells.\n" +
            "\n" +
            "The program is written in JAVA programming language version 18 in 2023.  \n" +
            "\n" +
            "Author: Philip Suprun\n";
    public static final String MESSAGE_QUESTION_ABOUT_MATRIX_SIZE = "Enter the desired matrix size. Valid values are " +
            "from 1 to 20.";

    private ContentApp() {

    }
}
