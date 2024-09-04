import javax.sound.midi.Track;
import java.time.LocalDateTime;

public class AddCommand extends Command {
    public AddCommand(String[] arguments) {
        super(false);
        super.arguments = arguments;
    }

    @Override
    public void execute(TaskList tasklist, Ui ui, Storage storage) {
        try {
            switch (arguments[0]) {
                case "todo":
                    tasklist.addTodoTask(arguments);
                    break;
                case "deadline":
                    tasklist.addDeadlineTask(arguments);
                    break;
                case "event":
                    tasklist.addEventTask(arguments);
            }
            storage.save(tasklist);
        } catch (TrackieException e) {
            ui.displayErrorMessage(e);
        }
    }
}
