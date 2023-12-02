package com.example.taskToDo.controller;
import com.example.taskToDo.models.Task;
import com.example.taskToDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/save") // create and update
    ResponseEntity<?> saveTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
    }

    @GetMapping("/getTasksById/{id}")
    ResponseEntity<?> findById(@RequestParam Integer id){
        return ResponseEntity.ok(taskService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.findAll(task));
    }
}
