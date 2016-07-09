package com.cmwchoi.services;

import com.cmwchoi.models.Task;
import com.cmwchoi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 6/28/16.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private List<Task> tasks = new ArrayList<>();
    private int nextId = 0;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    @Override
    public Task get(Integer id) {
        for (Task task : tasks) {
            if (id.equals(task.getId())) return task;
        }
        return null;
    }

    @Override
    public void update(Task task) {
        delete(task.getId());
        tasks.add(task);
    }

    @Override
    public void delete(Integer id) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (id.equals(task.getId())) taskToRemove = task;
        }
        if (taskToRemove != null) tasks.remove(taskToRemove);
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }
}
