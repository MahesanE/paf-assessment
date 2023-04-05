package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6

@Repository
public class TaskRepository {

    private static final String INSERT_TASK_SQL = "INSERT INTO task (description, priority, due_date, user_id)" +
    "VALUES (?, ?, ?, ?)"; 

    @Autowired
    JdbcTemplate template;

    public Boolean insertTask(Task task){
        try {
            int rowsAffected = template.update(INSERT_TASK_SQL, task.getDescription(), task.getPriority(), task.getDueDate(), task.getUser());
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
}
