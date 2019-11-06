import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ToDoList {
    private final HashMap<String, Task> tasks = new HashMap<String, Task>();

    public void addTask(final Task task) {
        // Add code here
        this.tasks.put(task.getDescription(), task);
    }

    public void completeTask(final String description) {
        // Add code here
        this.tasks.get(description).setComplete(true);
    }

    public boolean getStatus(final String description) {
        // Add code her
        return this.tasks.get(description).isComplete();
    }

    public Task getTask(final String description) {
        // Add code here
        return this.tasks.get(description);
    }

    public Task removeTask(final String description) {
        // Add code here
        return this.tasks.remove(description);
    }

    public Collection<Task> getAllTasks() {
        return this.tasks.values();
    }

    public Collection<Task> getCompletedTasks() {
        // Add code here
        return this.tasks.values().stream().filter(task -> task.isComplete() == true).collect(Collectors.toList());

    }
}
