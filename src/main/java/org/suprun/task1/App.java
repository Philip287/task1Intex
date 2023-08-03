package org.suprun.task1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.suprun.task1.command.CommandExecutor;
import org.suprun.task1.exception.CustomAppException;
import org.suprun.task1.service.MessageHelper;
import org.suprun.task1.service.Operation;

public class App {
    private static final Logger LOGGER = LogManager.getLogger();
    public static boolean exit = false;

    public static void main(String[] args) {
        try {
            Operation operation = Operation.INFO;
            CommandExecutor.execution(operation);
            do {
                operation = MessageHelper.askOperation();
                CommandExecutor.execution(operation);
                if (operation != Operation.EXIT) {
                    CommandExecutor.execution(Operation.EXIT);
                }
            } while (!exit);
        } catch (CustomAppException e) {
            LOGGER.error("", e);
        }

    }
}
