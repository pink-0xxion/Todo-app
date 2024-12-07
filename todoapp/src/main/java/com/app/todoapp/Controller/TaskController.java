package com.app.todoapp.Controller;

import com.app.todoapp.Services.TaskService;
import com.app.todoapp.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RestController   <---if you want to make a REST API app
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTask(Model model) {    // the Model is used to pass data from the controller to the view (e.g., an HTML template)
//        System.out.println("getTask Called");
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks); //This line adds data to the Model, making it available for rendering in the view.
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
