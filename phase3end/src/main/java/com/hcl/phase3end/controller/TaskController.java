package com.hcl.phase3end.controller;

import com.hcl.phase3end.model.Task;
import com.hcl.phase3end.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/create-task")
    public ModelAndView createTaskForm() {
        Task task = new Task();
        return new ModelAndView("create-task", "newTask", task);
    }

    @PostMapping("/create-task")
    public ModelAndView createTask(@RequestParam("name") String name,
                                   @RequestParam("startDate") String startDate,
                                   @RequestParam("endDate") String endDate,
                                   @RequestParam("description") String description,
                                   @RequestParam("email") String email,
                                   @RequestParam("priority") String priority){
        Task task = new Task();
        task.setName(name);
        task.setStartDate(startDate);
        task.setEndDate(endDate);
        task.setDescription(description);
        task.setEmail(email);
        task.setPriority(priority);
        if(taskService.createTask(task)){
            return new ModelAndView("redirect:/display-tasks", "taskList", taskService.retrieveTasks());
        } else{
            return new ModelAndView("error", "errorMessage","Error: task not created.");
        }
    }

    @GetMapping("/display-tasks")
    public ModelAndView displayTasks(){
        return new ModelAndView("display-tasks", "taskList", taskService.retrieveTasks());
    }

    @GetMapping("/update-task/{id}")
    public ModelAndView updateTask(@PathVariable("id") int id){
        Task task = taskService.retrieveTask(id);
        if(task!=null)return new ModelAndView("update-task","task",task);
        return new ModelAndView("error","errorMessage","Error: Task does not exist.");
    }

    @PostMapping("/update-task/{id}")
    public ModelAndView updateTask(@PathVariable("id") int id,
                                   @RequestParam("name") String name,
                                   @RequestParam("startDate") String startDate,
                                   @RequestParam("endDate") String endDate,
                                   @RequestParam("description") String description,
                                   @RequestParam("email") String email,
                                   @RequestParam("priority") String priority){
        if(taskService.updateTask(id, name, startDate, endDate, description, email, priority)){
            return new ModelAndView("redirect:/display-tasks", "taskList", taskService.retrieveTasks());
        } else{
            return new ModelAndView("error", "errorMessage","Error: task could not be updated.");
        }
    }

    @GetMapping("/delete-task/{id}")
    public ModelAndView deleteTask(@PathVariable("id") int id){
        taskService.deleteTask(id);
        return new ModelAndView("redirect:/display-tasks", "taskList", taskService.retrieveTasks());
    }


}
