package com.cmwchoi.repositories;

import com.cmwchoi.models.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Christian on 7/6/16.
 */
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
