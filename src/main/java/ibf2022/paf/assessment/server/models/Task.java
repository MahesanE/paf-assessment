package ibf2022.paf.assessment.server.models;

import java.time.LocalDate;

// TODO: Task 4

public class Task {
    private int taskId;
    private String description;
    private int priority;
    private LocalDate dueDate;
    private User user;

    public Task() {}

    public int getTaskId() { return this.taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public int getPriority() { return this.priority; }
    public void setPriority(int priority) { this.priority = priority; }

    public LocalDate getDueDate() { return this.dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public User getUser() { return this.user; }
    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", description=" + description + ", priority=" + priority
                + ", dueDate=" + dueDate + ", user=" + user.getUserId() + "]";
    }
}
