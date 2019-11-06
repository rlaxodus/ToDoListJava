
public class Task {
    private String taskName = null;
    private String description = null;
    private boolean isComplete = false;

    public Task(final String description) {
        super();
        this.description = description;
    }

    public Task(final String taskName, final String description, final boolean isComplete) {
        super();
        this.description = description;
        this.isComplete = isComplete;
        this.taskName = taskName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setComplete(final boolean isComplete) {
        this.isComplete = isComplete;
    }

}
