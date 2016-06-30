package com.cmwchoi.dao;

import com.cmwchoi.models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Christian on 6/28/16.
 */
public class TaskDaoImpl implements TaskDao {

    private List<Task> tasks = new ArrayList<Task>();
    private int nextId = 0;

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
    public List<Task> findTasksByUser(Integer userId) {
        return tasks.stream().filter(t -> t.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
