package trackie.commands;

import trackie.storage.Storage;
import trackie.storage.TaskList;
import trackie.ui.Ui;

/**
 * Represents a command that tells the chatbot to exit and shutdown.
 */
public class ExitCommand extends Command {
    /**
     * Constructs a new ExitCommand.
     */
    public ExitCommand() {
        super(true);
    }

    /**
     * Executes the exit command.
     *
     * Once the exit command is run, the program will save the current state of the tasklist
     * to the memory before quitting.
     *
     * @param tasklist The TaskList object whose state is to be saved to memory.
     * @param ui The Ui object used to display messages to the user.
     * @param storage The Storage object used to save the state of the task list.
     */
    @Override
    public void execute(TaskList tasklist, Ui ui, Storage storage) {
        storage.save();
        ui.sayGoodbyeMessage();
    }
}
