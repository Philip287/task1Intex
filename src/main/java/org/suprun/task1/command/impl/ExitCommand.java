package org.suprun.task1.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.suprun.task1.App;
import org.suprun.task1.command.Command;
import org.suprun.task1.exception.CustomAppException;
import org.suprun.task1.service.ContentApp;
import org.suprun.task1.service.MessageHelper;

/**
 * {@code ExitCommand} a class that implements the function of exiting the App application.
 *
 * @author Philip Suprun
 */
public class ExitCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public ExitCommand() {

    }

    @Override
    public void execute() throws CustomAppException {
        boolean work = true;
        MessageHelper.writeMessage(ContentApp.QUESTION_EXIT_MESSAGE);
        do {
            String answer = MessageHelper.readString();
            if (answer.equals(ContentApp.CHOICE_1)) {
                work = false;
                App.exit = true;
            } else if (answer.equals(ContentApp.CHOICE_2)) {
                App.exit = false;
                work = false;
            } else {
                MessageHelper.writeMessage(ContentApp.WRONG_MESSAGE);
                LOGGER.error("Incorrect input: " + answer);
            }
        } while (work);
    }
}
