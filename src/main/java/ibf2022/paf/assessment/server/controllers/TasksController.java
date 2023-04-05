package ibf2022.paf.assessment.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.TaskForm;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@Controller
public class TasksController {

    @Autowired
    TodoService todoSvc;

   
    
    @PostMapping(path = "/task", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveTask(@RequestBody String payload){
        System.out.println(">>> " + payload);

        List<TaskForm> taskForm = Utils.toTaskFormList(payload);

        //Boolean success = todoSvc.upsertTask(taskForm, payload);
        
        
        return null;
    }
    
}
