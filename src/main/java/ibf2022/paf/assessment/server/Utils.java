package ibf2022.paf.assessment.server;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ibf2022.paf.assessment.server.models.TaskForm;

public class Utils {

    public static List<TaskForm> toTaskFormList(String payload) {
        List<TaskForm> taskForms = new ArrayList<>();
        String[] parts = payload.split("&");

        String userName = parts[0].split("=")[1];

        for (int i = 1; i < parts.length; i += 3) {
            String description = parts[i].split("=")[1];
            int priority = Integer.parseInt(parts[i + 1].split("=")[1]);
            Date dueDate = Date.valueOf(parts[i + 2].split("=")[1]);

            TaskForm taskForm = new TaskForm();
            taskForm.setUsername(userName);
            taskForm.setDescription(description);
            taskForm.setPriority(priority);
            taskForm.setDueDate(dueDate);
            taskForms.add(taskForm);
        }

        return taskForms;
    }

}
