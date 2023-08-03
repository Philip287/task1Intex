package org.suprun.task1.command;

import org.suprun.task1.exception.CustomAppException;

/**
 * {@code Command} is a functional interface implementing instances of which
 * execution command.
 *
 * @author Philip Suprun
 */
public interface Command {
    void execute() throws CustomAppException;

}
