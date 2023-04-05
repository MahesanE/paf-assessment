package ibf2022.paf.assessment.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.TaskForm;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@Controller
public class TasksController {

    @Autowired
    TodoService todoSvc;

    @PostMapping(path = "/task")
    public ModelAndView saveTask(@RequestBody String payload) {
        System.out.println(">>> " + payload);
        List<TaskForm> taskForms = Utils.toTaskFormList(payload);
        String username = taskForms.get(0).getUsername();
        List<Task> tasks = new ArrayList<>();
        for (TaskForm taskForm : taskForms) {
            Task task = new Task();
            task.setDescription(taskForm.getDescription());
            task.setPriority(taskForm.getPriority());
            task.setDueDate(taskForm.getDueDate());
            tasks.add(task);
        }
        boolean success = todoSvc.upsertTask(tasks, username);

        if (success) {
            ModelAndView mav = new ModelAndView("result.html");
            mav.addObject("taskCount", tasks.size());
            mav.addObject("username", username);
            return mav;
        } else {
            return new ModelAndView("error.html");
        }
    }
}
