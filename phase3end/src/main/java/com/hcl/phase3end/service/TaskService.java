package com.hcl.phase3end.service;

import com.hcl.phase3end.dao.TaskDao;
import com.hcl.phase3end.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;

    public boolean createTask(Task task) {
        try {
            taskDao.save(task);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Task retrieveTask(int id) {
        if (taskDao.findById(id).isPresent()) return taskDao.findById(id).get();
        else return null;
    }

    public List<Task> retrieveTasks() {
        return (List<Task>) taskDao.findAll();
    }

    public boolean updateTask(int id, String name, String startDate, String endDate, String description, String email, String priority) {
        try {
            taskDao.deleteById(id);

            Task task = new Task();
            task.setName(name);
            task.setStartDate(startDate);
            task.setEndDate(endDate);
            task.setDescription(description);
            task.setEmail(email);
            task.setPriority(priority);

            taskDao.save(task);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void deleteTask(int id) {
        taskDao.deleteById(id);
    }
}
