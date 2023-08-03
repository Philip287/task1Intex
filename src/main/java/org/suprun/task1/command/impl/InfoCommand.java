package org.suprun.task1.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.suprun.task1.App;
import org.suprun.task1.command.Command;
import org.suprun.task1.exception.CustomAppException;
import org.suprun.task1.service.ContentApp;
import org.suprun.task1.service.MessageHelper;

/**
 * {@code InfoCommand} a class that implements the function of info about work App application.
 *
 * @author Philip Suprun
 */
public class InfoCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public InfoCommand() {

    }

    @Override
    public void execute() throws CustomAppException {
        MessageHelper.writeMessage(ContentApp.MESSAGE_INFO);
    }
}
