package ibf2022.paf.assessment.server;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ibf2022.paf.assessment.server.models.TaskForm;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {
    public static List<TaskForm> toTaskFormList(String jsonStr) {

        List<TaskForm> taskFormList = new ArrayList<>();
        JsonReader reader = Json.createReader(new StringReader(jsonStr));
        JsonObject json = reader.readObject();
    
        // Get the number of tasks in the JSON
        int numTasks = json.keySet().stream().filter(key -> key.startsWith("description")).toArray().length;
    
        // Iterate through each task and create a new TaskForm object
        for (int i = 0; i < numTasks; i++) {
            TaskForm taskForm = new TaskForm();
            taskForm.setDescription(json.getString("description-" + i));
            taskForm.setPriority(json.getInt("priority-" + i));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dueDate = LocalDate.parse(json.getString("dueDate-" + i), formatter);
            taskForm.setDueDate(dueDate);
            taskFormList.add(taskForm);
        }
    
        return taskFormList;
    }
    

}
