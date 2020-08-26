package duke.command;

import duke.Bot;
import duke.task.Task;
import duke.task.TaskList;

/**
 * This Command will mark a Task as done.
 */
public class DoneCommand implements Command {
    private int index;

    /**
     * Creates a DoneCommand.
     *
     * @param index index of the Task to mark as done
     */
    public DoneCommand(int index) {
       this.index = index;
    }

    @Override
    public void execute(Bot bot, TaskList list) {
        if (list.size() == 0) {
            bot.sayLine("Your list is empty.");
        } else if (index < 0) {
            bot.sayLine("That's not a valid number, please give a number from 1 to " + list.size() + ".");
        } else if (index >= list.size()) {
            bot.sayLine(String.format("That's not a valid number, you only have %d item(s) in your list.", list.size()));
        } else {
            Task t = list.get(index);
            if (t.isDone()) {
                bot.sayLine("You've already completed this task:");
            } else {
                list.markAsDone(index);
                bot.sayLine("Nice! I've marked this task as done:");
            }
            bot.sayLine("  " + t.displayString());
        }
    }
}
