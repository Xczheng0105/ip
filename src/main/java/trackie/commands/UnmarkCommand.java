package trackie.commands;

import trackie.storage.Storage;
import trackie.storage.TaskList;
import trackie.tasks.Task;
import trackie.ui.TrackieException;
import trackie.ui.Ui;

public class UnmarkCommand extends Command {
    public UnmarkCommand(String[] arguments) {
        super(false);
        super.arguments = arguments;
    }
    /**
     * Executes the unmark command.
     * This method will cause the tasklist to mark a task as not completed.
     * The user will be informed of the task's new status, which would be changed to
     * not completed after the unmarking operation.
     *
     * @param tasklist The TaskList object from which a task will be unmarked.
     * @param storage The Storage object used to save the updated task list.
     */
    @Override
    public String execute(TaskList tasklist, Storage storage) {
        try {
            if (arguments.length == 1) {
                throw new TrackieException("Please specify an index to unmark!");
            }

            int number = Integer.parseInt(arguments[1]);

            if (number < 1 || number > tasklist.size()) {
                throw new TrackieException("Invalid index.");
            }
            tasklist.unmarkTask(number - 1);
            storage.save();
            return "Aight, I've unmarked the following: " + tasklist.getTasks().get(number - 1).toString();
        } catch (TrackieException e) {
            return e.getMessage();
        }
    }
}
