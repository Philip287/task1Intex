package org.suprun.task1.command;

import org.suprun.task1.command.impl.DisplayPyramidMatrixCommand;
import org.suprun.task1.command.impl.DisplaySnakeMatrixCommand;
import org.suprun.task1.command.impl.ExitCommand;
import org.suprun.task1.command.impl.InfoCommand;
import org.suprun.task1.exception.CustomAppException;
import org.suprun.task1.service.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code CommandExecutor} class provides logic for executing command.
 *
 * @author Philip Suprun
 */
public class CommandExecutor {
    private static final Map<Operation, Command> commandMap = new HashMap<>();

    static {
        commandMap.put(Operation.INFO, new InfoCommand());
        commandMap.put(Operation.SNAKE_MATRIX, new DisplaySnakeMatrixCommand());
        commandMap.put(Operation.PYRAMID_MATRIX, new DisplayPyramidMatrixCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {

    }

    public static void execution(Operation operation) throws CustomAppException {
        commandMap.get(operation).execute();
    }

}
