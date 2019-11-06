import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ToDoList {
    private final HashMap<String, Task> tasks = new HashMap<String, Task>();

    public void addTask(final Task task) {
        // Add code here
        this.tasks.put(task.getTaskName(), task);
    }

    public void completeTask(final String taskName) {
        // Add code here
        this.tasks.get(taskName).setComplete(true);
    }

    public boolean getStatus(final String taskName) {
        // Add code her
        return this.tasks.get(taskName).isComplete();
    }

    public Task getTask(final String taskName) {
        // Add code here
        if(tasks.containsKey(taskName)) {
        	 return this.tasks.get(taskName);
        }
        return null;
        
    }

    public Task removeTask(final String taskName) {
        // Add code here
        return this.tasks.remove(taskName);
    }

    public Collection<Task> getAllTasks() {
        return this.tasks.values();
    }

    public Collection<Task> getCompletedTasks() {
        // Add code here
        return this.tasks.values().stream().filter(task -> task.isComplete() == true).collect(Collectors.toList());

    }

    public Collection<Task> searchTaskByDescription(final String searchString) {
        return getAllTasks().stream().filter(task -> task.getDescription().contains(searchString))
                .collect(Collectors.toList());
    }

    public Task editTask(final Task task) {
        // Add code here
        if (this.tasks.containsKey(task.getTaskName())) {
            this.tasks.remove(task.getTaskName());
            addTask(task);
            return this.tasks.get(task.getTaskName());
        }
        return null;
    }
}
