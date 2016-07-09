package com.cmwchoi.controllers;

import com.cmwchoi.services.TaskService;
import com.cmwchoi.models.Task;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Created by Christian on 5/27/16.
 */

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskDao(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task());
        return "tasks";
    }

    @RequestMapping(value = "/task/new", method = RequestMethod.POST)
    @ResponseBody
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public Task create(@Valid @RequestBody Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setCompleted(false);
        Task newTask = taskService.create(task);
        return newTask;
//        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/{id}/complete", method = RequestMethod.GET)
    public String markComplete(@PathVariable("id") Integer id) {
        Task task = taskService.get(id);
        task.setCompleted(true);
        taskService.update(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

}
