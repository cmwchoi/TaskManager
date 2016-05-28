package dao;

import models.Task;

import java.util.List;

/**
 * Created by Christian on 5/27/16.
 */
public interface TaskDao {

    Task create(Task task);
    Task get(Integer id);
    void update(Task task);
    void delete(Integer id);
    List<Task> findTasksByUser(Integer userId);

}
