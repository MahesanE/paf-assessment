package ibf2022.paf.assessment.server.models;

import java.sql.Date;


// TODO: Task 4

public class Task {
    private int taskId;
    //private String userId;
    private String description;
    private int priority;
    private Date dueDate;
    private User user;
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Task(int taskId, String description, int priority, Date dueDate, User user) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.user = user;
    }
    public Task() {
    }
    
    
    

    

    
    

    

    
}
